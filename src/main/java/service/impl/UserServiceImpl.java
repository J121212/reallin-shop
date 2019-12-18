package service.impl;

import com.github.pagehelper.PageHelper;
import dao.UserMapper;
import org.springframework.stereotype.Service;
import pojo.User;
import service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/9/24.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;



    public int getUserNum() {
        List<User> users=userMapper.getUserList();
        return users.size();
    }

    public List<User> getPageUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userMapper.getUserList();
        return list;
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public void updateUserName(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    public User selectByPrimaryKey(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void deleteUserById(String idArr) {
            userMapper.deleteByPrimaryKey(Integer.parseInt(idArr));
    }

    public List<User> getPageUserByUser(String phone, String username, String wechat, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> list=userMapper.getUserListByUser(phone,username,wechat);
        return list;
    }

    public int updateGoodsNum(Integer id, Integer goodsNum) {
        return userMapper.updateGoodsNum(id,goodsNum);
    }

    public User getUserByPhone(String phone) {
        User user  = userMapper.getUserByPhone(phone);
        return  user;
    }

    public void addUser(User user) {
        userMapper.insert(user);
    }

    public List<User> getUserOrderByDate(int size) {
        PageHelper.startPage(1, size);
        List<User> list = userMapper.getUserListOrderByCreateAt();
        return list;
    }


}
