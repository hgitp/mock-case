package cn.com.do1.mock.service.impl;

import cn.com.do1.mock.service.IMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 消息服务-demo
 * @Author huangKun
 * @Date 2021/3/16
 **/
@Service
public class MessageServiceImpl implements IMessageService {

    public static final Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

    /**
     * 消息通知
     * @param obj
     */
    public void sendMsg(Object obj) {
        log.info("MessageService send message!");
    }
}
