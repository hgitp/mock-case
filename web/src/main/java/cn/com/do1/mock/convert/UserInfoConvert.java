package cn.com.do1.mock.convert;

import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.vo.UserInfoVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import sun.rmi.runtime.Log;

import java.util.Optional;

/**
 * @Author huangKun
 * @Date 2021/3/24
 **/
@Slf4j
public class UserInfoConvert {

    static {
        log.info(">>>>>>start load static block");
    }


    /**
     * entity转换vo
     * @param entity
     * @return
     */
    public static UserInfoVO convertEntityToVO(TUserInfo entity){
        UserInfoVO userInfoVO = new UserInfoVO();
        if (null != entity){
            BeanUtils.copyProperties(entity, userInfoVO);
        }
        return userInfoVO;
    }
}
