package cn.com.do1.mock.service;

import cn.com.do1.mock.model.TUserInfo;
import cn.com.do1.mock.vo.UserInfoVO;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

public interface IUserInfoService extends IService<TUserInfo> {

    UserInfoVO selectUser(String identity);

    List<TUserInfo> selectUserList(String userId);

    TUserInfo updateUserInfo(String identity);
}
