package cn.com.do1.mock.service.impl;

import cn.com.do1.mock.convert.UserInfoConvert;
import cn.com.do1.mock.dao.UserInfoDao;
import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.service.IMessageService;
import cn.com.do1.mock.service.IUserInfoService;
import cn.com.do1.mock.util.LocalCacheUtil;
import cn.com.do1.mock.util.RedisUtil;
import cn.com.do1.mock.vo.UserInfoVO;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用户服务-demo
 * @Author huangKun
 * @Date 2021/3/16
 **/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoDao, TUserInfo> implements IUserInfoService {

    public static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

    @Resource private UserInfoDao userInfoDao;

    @Autowired private IMessageService messageService;

    /**
     * 根据身份证查询用户信息
     * @param identity
     * @return
     */
    public UserInfoVO selectUser(String identity) {
        // 查询用户entity
        TUserInfo userInfoEntity = userInfoDao.selectByIdentity(identity);
        // 数据模型转换
        UserInfoVO userInfoVO = UserInfoConvert.convertEntityToVO(userInfoEntity);
        return userInfoVO;
    }

    public List<TUserInfo> selectUserList(String userId) {
        if (StringUtils.isEmpty(userId)){
            return new ArrayList<>();
        }
        // 根据userId从本来缓存获取用户信息
        TUserInfo userInfo = new LocalCacheUtil().getUserCache(userId);
        return Arrays.asList(userInfo);
    }

    public TUserInfo updateUserInfo(String identity) {
        TUserInfo userInfo = userInfoDao.selectByIdentity(identity);
        // 如果用户年龄大于10，则加1
        int updateResult = 0;
        if (null != userInfo.getAge() && userInfo.getAge().intValue() > 10){
            userInfo.setAge(userInfo.getAge() +1);
            updateResult = userInfoDao.updateById(userInfo);
        }
        // 变更消息发送
        if (updateResult > 0){
            messageService.sendMsg(userInfo);
        }
        return userInfo;
    }
}
