package io.github.rothschil.domain.entity;

import io.github.rothschil.base.persistence.jpa.entity.BaseJpaPo;
import io.github.rothschil.enums.GenderEnum;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@DynamicUpdate
@Entity(name = "user")
public class User extends BaseJpaPo<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /** 平台用户姓名 */
    private String username;

    /** 平台用户密码 */
    private String password;

    /** 性别 默认未知 0 男 1 女 2*/
    private Integer gender = GenderEnum.UNKNOWN.getCode();

    /** 手机号 */
    private String phone;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
