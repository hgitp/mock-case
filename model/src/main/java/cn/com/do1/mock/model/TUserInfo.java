package cn.com.do1.mock.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 用户信息
 * @Author huangKun
 * @Date 2021/3/16
 **/
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_info")
@Builder
public class TUserInfo {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private Integer age;

    private String identity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }
}
