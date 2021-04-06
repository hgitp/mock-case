package cn.com.do1.mock.service;

import cn.com.do1.mock.TestStartApplication;
import cn.com.do1.mock.dao.UserInfoDao;
import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.service.impl.UserInfoServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * 单元测试-用户服务mock
 * @Author huangKun
 * @Date 2021/3/16
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestStartApplication.class)
public class UserInfoServiceMockTest {

    public static final Logger log = LoggerFactory.getLogger(UserInfoServiceMockTest.class);

    @InjectMocks private UserInfoServiceImpl userInfoService;
    @Mock private UserInfoDao userInfoDaoMock;
    @Mock private IMessageService messageServiceMock;

    /**
     * 通用场景，关注以下点
     * 1、对外部依赖mock，无需模拟返回，即void类型方法
     * 2、对外部依赖mock，需模拟返回值，即有return类型方法
     */
    @Test
    public void testUpdateUserInfo(){
        // mock数据dao层逻辑
        TUserInfo userInfoEntity = new TUserInfo();
        userInfoEntity.setAge(20);

        when(userInfoDaoMock.selectByIdentity(anyString())).thenReturn(userInfoEntity);
        when(userInfoDaoMock.updateById(any())).thenReturn(1);
        // mock其他服务层逻辑
        doNothing().when(messageServiceMock).sendMsg(any());
        // 调用测试方法
        TUserInfo actualUserInfo = userInfoService.updateUserInfo("442110201001011235");
        // 验证接口返回
        Assert.assertEquals(actualUserInfo.getAge().intValue(), 21);
    }


}
