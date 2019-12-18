package service;

import pojo.User;

import java.util.List;

/**
 * Created by pc on 2019/9/24.
 */
public interface UserService {
    public int getUserNum();

    public List<User> getPageUser(int pageNum,int pageSize);

    public User getUserById(int id);

    public void updateUserName(User user);

    User selectByPrimaryKey(Integer id);

    public void deleteUserById(String idArr);

    public List<User> getPageUserByUser(String phone,String username, String wechat,int pageNum,int pageSize);

    int updateGoodsNum(Integer id, Integer goodsNum);

    public User getUserByPhone(String phone);

    public void addUser(User user);

    public List<User> getUserOrderByDate(int size);
}
