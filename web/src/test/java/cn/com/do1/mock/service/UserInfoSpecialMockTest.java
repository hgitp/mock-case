package cn.com.do1.mock.service;

import cn.com.do1.mock.TestStartApplication;
import cn.com.do1.mock.convert.UserInfoConvert;
import cn.com.do1.mock.dao.UserInfoDao;
import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.service.impl.UserInfoServiceImpl;
import cn.com.do1.mock.util.LocalCacheUtil;
import cn.com.do1.mock.vo.UserInfoVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * 特殊mock测试场景，即模拟静态方法，构造函数，final类和方法，私有方法，去除静态初始化器等
 * 1、需要测试运行容易需要用PowerMockRunner，即用powerMock提供的api,mockito暂无法模拟
 * 2、当前测试类需要增加@PrepareForTest注解
 * @Author huangKun
 * @Date 2021/3/24
 **/
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserInfoConvert.class, LocalCacheUtil.class})
@SpringBootTest(classes = {TestStartApplication.class})

//@SuppressStaticInitializationFor({
//        "cn.com.do1.mock.convert.UserInfoConvert"})//阻止静态代码块运行
public class UserInfoSpecialMockTest {
    @InjectMocks
    private UserInfoServiceImpl userInfoService;
    @Mock
    private UserInfoDao userInfoDaoMock;
    @Before
    public void setup(){
        // 静态方法mock前需要先对整个静态类mock，将目标类加载powerMock自定义类加载器
        PowerMockito.mockStatic(UserInfoConvert.class);
    }

    /**
     * powerMock模拟静态方法以及静态块示例，需注意以下2点
     * 1、静态方法在mock前，需要对整个静态类mock
     * 2、@PrepareForTest注解中标明涉及静态方法和快的类
     jectMo  */
    @Test
    public void testSelectUser(){
        // 预设参数
        String expect = "123";
        String identity = "abc";
        TUserInfo userInfoEntity = TUserInfo.builder().identity(identity).build();
        // 模拟dao返回用户信息
        when(userInfoDaoMock.selectByIdentity(anyString())).thenReturn(userInfoEntity);
        // 模拟静态方法返回
        UserInfoVO mockUserInfoVo = UserInfoVO.builder().identity(expect).build();
        PowerMockito.when(UserInfoConvert.convertEntityToVO(userInfoEntity)).thenReturn(mockUserInfoVo);

        // 调用测试方法
        UserInfoVO userInfoVO = userInfoService.selectUser(identity);
        // 断言
        Assert.assertEquals(expect, userInfoVO.getIdentity());
    }

    /**
     * 类静态块mock测试示例
     */
    @Test
    public void testSelectUserList(){
//        TUserInfo userInfoExpect = TUserInfo.builder().userName("张三").build();
//        // powerMock初始化静态类
//        LocalCacheUtil localCacheUtilMock = PowerMockito.mockStatic();
//        // 调用static类
//        List<TUserInfo> userInfoList = userInfoService.selectUserList("234");
//        Assert.assertEquals(1, userInfoList.size());
    }
}
