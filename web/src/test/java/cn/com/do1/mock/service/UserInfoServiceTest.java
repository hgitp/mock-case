package cn.com.do1.mock.service;

import cn.com.do1.mock.TestStartApplication;
import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.vo.UserInfoVO;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 单元测试-用户服务
 * @Author huangKun
 * @Date 2021/3/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestStartApplication.class)
public class UserInfoServiceTest {

    public static final Logger log = LoggerFactory.getLogger(UserInfoServiceTest.class);

    @Autowired private IUserInfoService userInfoService;

    @Test
    public void testSelectUser(){
        String identity = "442110201001011235";
        UserInfoVO userInfo = userInfoService.selectUser(identity);
        log.info(JSON.toJSONString(userInfo));
    }
}
