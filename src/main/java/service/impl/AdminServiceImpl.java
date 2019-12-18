package service.impl;

import dao.AdminMapper;
import org.springframework.stereotype.Service;
import pojo.Admin;
import service.AdminService;

import javax.annotation.Resource;

/**
 * Created by pc on 2019/9/22.
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    public Admin login(Long account, String password) {
        return adminMapper.login(account,password);
    }

    public void updateAdmin(Admin admin) {
        adminMapper.updateAdmin(admin);
    }

    public Admin findAdminById(Integer id) {
        return null;
    }


}
