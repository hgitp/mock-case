package cn.com.do1.mock.dao;

import cn.com.do1.mock.model.TUserInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserInfoDao extends BaseMapper<TUserInfo> {

    @Select("select * from t_user_info where identity = #{identity}")
    TUserInfo selectByIdentity(String identity);

    @Select("select * from t_user_info where age = #{age}")
    List<TUserInfo> selectUserListByAge(int age);

    @Update("update t_user_info set age = #{age} where id = #{id}")
    int updateById(Long id, int age);

    @Delete("delete from t_user_info where id=#{id}")
    int deleteById(Long id);
}
