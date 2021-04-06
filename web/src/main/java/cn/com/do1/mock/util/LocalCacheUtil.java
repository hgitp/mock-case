package cn.com.do1.mock.util;

import cn.com.do1.mock.model.TUserInfo;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author huangKun
 * @Date 2021/3/24
 **/
@Slf4j
public class LocalCacheUtil {

    public static Map<String, TUserInfo> USER_CACHE = new HashMap<>();

    static RedisUtil redisUtil = new RedisUtil();

    static {
        log.info(">>>>>>loading static block");
        USER_CACHE.put("user1", (TUserInfo)redisUtil.getByKey("user1"));
    }

    public TUserInfo getUserCache(String userId){
        if (null == USER_CACHE){
            log.info(">>>>>>static block not load");
            return null;
        }
        return USER_CACHE.get(userId);
    }
}
