package service;

import pojo.Admin;

/**
 * Created by pc on 2019/9/22.
 */
public interface AdminService {

    public Admin login(Long account,String password);

    public void updateAdmin(Admin admin);

    public Admin findAdminById(Integer id);
}
