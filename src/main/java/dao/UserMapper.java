package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

/**
 * Created by pc on 2019/9/24.
 */
public interface UserMapper {
   public List<User> getUserList();

    User getUserById(int id);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKey(User record);

    int deleteByPrimaryKey(Integer id);

    List<User> getUserListByUser(@Param("phone") String phone,@Param("username") String username,@Param("wechat") String wechat);

 int updateGoodsNum(@Param("id") Integer id, @Param("goodsNum") Integer goodsNum);//更改用户的商品数量

 User getUserByPhone(String phone);//通过手机号查询用户

 int insert(User record);

 List<User> getUserListOrderByCreateAt();


}
