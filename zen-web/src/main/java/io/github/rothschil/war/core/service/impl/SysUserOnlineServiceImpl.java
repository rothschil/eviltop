package io.github.rothschil.war.core.service.impl;

import io.github.rothschil.common.utils.DateUtils;
import io.github.rothschil.common.utils.StringUtils;
import io.github.rothschil.war.constant.ShiroConstants;
import io.github.rothschil.war.core.domain.SysUserOnline;
import io.github.rothschil.war.core.mapper.SysUserOnlineMapper;
import io.github.rothschil.war.core.service.ISysUserOnlineService;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.Deque;
import java.util.List;

/**
 * 在线用户
 *
 * @author <a href="https://github.com/rothschil">Sam</a>
 * @date 2019/10/10 - 0:04
 * @since 1.0.0
 */
@Service
public class SysUserOnlineServiceImpl implements ISysUserOnlineService {

    @Autowired
    private SysUserOnlineMapper sysUserOnlineMapper;

    @Autowired
    private EhCacheManager ehCacheManager;

    /**
     * 通过会话序号查询信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public SysUserOnline selectOnlineById(String sessionId) {
        return sysUserOnlineMapper.selectOnlineById(sessionId);
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    @Override
    public void deleteOnlineById(String sessionId) {
        SysUserOnline userOnline = selectOnlineById(sessionId);
        if (StringUtils.isNotNull(userOnline)) {
            sysUserOnlineMapper.deleteOnlineById(sessionId);
        }
    }

    /**
     * 通过会话序号删除信息
     *
     * @param sessions 会话ID集合
     * @return 在线用户信息
     */
    @Override
    public void batchDeleteOnline(List<String> sessions) {
        for (String sessionId : sessions) {
            SysUserOnline userOnline = selectOnlineById(sessionId);
            if (StringUtils.isNotNull(userOnline)) {
                sysUserOnlineMapper.deleteOnlineById(sessionId);
            }
        }
    }

    /**
     * 保存会话信息
     *
     * @param online 会话信息
     */
    @Override
    public void saveOnline(SysUserOnline online) {
        sysUserOnlineMapper.saveOnline(online);
    }

    /**
     * 查询会话集合
     *
     * @param userOnline 在线用户
     */
    @Override
    public List<SysUserOnline> selectUserOnlineList(SysUserOnline userOnline) {
        return sysUserOnlineMapper.selectUserOnlineList(userOnline);
    }

    /**
     * 强退用户
     *
     * @param sessionId 会话ID
     */
    @Override
    public void forceLogout(String sessionId) {
        sysUserOnlineMapper.deleteOnlineById(sessionId);
    }

    /**
     * 清理用户缓存
     *
     * @param loginName 登录名称
     * @param sessionId 会话ID
     */
    @Override
    public void removeUserCache(String loginName, String sessionId) {
        Cache<String, Deque<Serializable>> cache = ehCacheManager.getCache(ShiroConstants.SYS_USERCACHE);
        Deque<Serializable> deque = cache.get(loginName);
        if (StringUtils.isEmpty(deque) || deque.size() == 0) {
            return;
        }
        deque.remove(sessionId);
    }

    /**
     * 查询会话集合
     *
     * @param expiredDate 失效日期
     */
    @Override
    public List<SysUserOnline> selectOnlineByExpired(Date expiredDate) {
        String lastAccessTime = DateUtils.parseDateToStr(DateUtils.DATETIME_PATTERN, expiredDate);
        return sysUserOnlineMapper.selectOnlineByExpired(lastAccessTime);
    }
}
