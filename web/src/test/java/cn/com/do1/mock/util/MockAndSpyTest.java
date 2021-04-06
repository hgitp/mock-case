package cn.com.do1.mock.util;

import cn.com.do1.mock.TestStartApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示@mock与@spy的区别
 * Mockito.mock() 等价于 @Mock
 * Mockito.spy()  等价于 @Spy
 * @Author huangKun
 * @Date 2021/3/30
 **/
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = TestStartApplication.class)
public class MockAndSpyTest {

    /**
     * mock对象由于本身只是一个骨架空壳，对mock对象后续的方法调用没有意义，也不生效。
     */
    @Test
    public void testVerifyWithMock(){
        List<String> mockList = Mockito.mock(ArrayList.class);
        mockList.add("123");
        Mockito.verify(mockList).add("123");
        Assert.assertEquals(1, mockList.size());
    }


    /**
     * spy构建的对象默认是有血有肉的，产生的是真实的对象实例，故拥有真实方法的行为，有别于mock对象；
     * spy创建的对象，除了可以调用真实方法，也可以模拟其行为
     */
    @Test
    public void testVerifyWithSpy(){
        List<String> mockList = Mockito.spy(ArrayList.class);
        mockList.add("123");
        Mockito.verify(mockList).add("123");
        Assert.assertEquals(1, mockList.size());
    }
}
