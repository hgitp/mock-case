package cn.com.do1.mock.vo;

import cn.com.do1.mock.model.TUserInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 自自定义-用户信息vo
 * @Author huangKun
 * @Date 2021/3/24
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserInfoVO {

    private String userName;

    private Integer age;

    private String identity;

    private String ext;
}
