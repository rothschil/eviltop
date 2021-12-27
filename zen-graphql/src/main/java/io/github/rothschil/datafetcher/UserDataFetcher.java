package io.github.rothschil.datafetcher;

import graphql.schema.DataFetcher;
import io.github.rothschil.constant.CookieConstant;
import io.github.rothschil.constant.RedisConstant;
import io.github.rothschil.domain.entity.User;
import io.github.rothschil.domain.service.UserService;
import io.github.rothschil.enums.GenderEnum;
import io.github.rothschil.enums.ResultEnum;
import io.github.rothschil.result.LoginMsg;
import io.github.rothschil.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class UserDataFetcher {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 平台用户注册
     */
    public DataFetcher save() {
        return dataFetchingEvn -> {
            LinkedHashMap linkedHashMap = dataFetchingEvn.getArgument("user");
            String username = (String) linkedHashMap.get("username");
            //只有用户名不重复的情况下 才可以注册
            if (userService.findByUsername(username) == null) {

                String gender = (String) linkedHashMap.get("gender");
                GenderEnum genderEnum = EnumUtil.getByMsg(gender, GenderEnum.class);
                linkedHashMap.put("gender", genderEnum.getCode().intValue());
                User user = (User) ToEntityUtil.entity(new User(), linkedHashMap);

                User responseUser = userService.save(user);
                if (responseUser == null) {
                    log.error("【用户注册】 {}", ResultEnum.REGISTER_FAIL.getMessage());
                    return ResultEnum.REGISTER_FAIL.getMessage();
                }
                return ResultEnum.REGISTER_SUCCESS.getMessage();
            }
            log.error("【用户注册】 {}", ResultEnum.USER_EXIST.getMessage());
            return ResultEnum.USER_EXIST.getMessage();
        };
    }


    /**
     * 平台用户登录
     */
    public DataFetcher login() {
        return dataFetchingEvn -> {
            String username = dataFetchingEvn.getArgument("username");
            String password = dataFetchingEvn.getArgument("password");
            User user = userService.findByUsernameAndPassword(username, password);
            if (user == null) {
                log.error("【用户登录】 username={},password={},{} ", username, password, ResultEnum.LOGIN_ERROR_USER_NOT_EXIST.getMessage());
                return ResultEnum.LOGIN_ERROR_USER_NOT_EXIST.getMessage();
            }

            String token = UUID.randomUUID().toString();//uuid生成token
            Integer expire = CookieConstant.EXPIRE;//过期时间
            //设置浏览器cookie
            CookieUtil.set(HttpUtil.response(), CookieConstant.TOKEN, token, expire);
            // TODO: 2019/5/29  通过session存储cookie


            //redis中缓存用户信息和cookie
            redisTemplate.opsForValue().set(
                    String.format(RedisConstant.TOKEN_PREFIX, token),//key
                    JsonUtil.toJson(user),//value
                    RedisConstant.EXPIRE,//过期时间
                    TimeUnit.SECONDS);//时间单位
            LoginMsg loginMsg = new LoginMsg(ResultEnum.LOGIN_SUCCESS.getMessage(), token);
            return loginMsg;
        };
    }


    /** 平台用户退出 */

    /**
     * 根据id查询
     */
    public DataFetcher userById() {
        System.err.println("asdfasdf");
        return dataFetchingEnvironment -> {
            String userId = dataFetchingEnvironment.getArgument("id");
            User user = userService.findById(Integer.valueOf(userId));
            return user;
        };
    }

    /**
     * 根据性别查询
     */
    public DataFetcher userByGender() {
        return dataFetchingEnvironment -> {
            String gender = dataFetchingEnvironment.getArgument("gender");
            GenderEnum genderEnum = EnumUtil.getByMsg(gender, GenderEnum.class);
            List userList = userService.userByGender(genderEnum.getCode().intValue());
            return userList;
        };
    }
}