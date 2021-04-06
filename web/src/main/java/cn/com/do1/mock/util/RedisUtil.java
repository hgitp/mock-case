package cn.com.do1.mock.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * redis连接操作工具类
 * @Author huangKun
 * @Date 2021/3/24
 **/
@Slf4j
public class RedisUtil {

    public Object getByKey(String key){
        log.info(">>>>>>connect redis and get key");
        return null;
    }
}
