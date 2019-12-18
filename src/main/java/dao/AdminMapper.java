package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import pojo.Admin;

/**
 * Created by pc on 2019/9/22.
 */
@Component
public interface AdminMapper {

    Admin login(@Param("account") Long account,@Param("password") String password);

    public void updateAdmin(Admin admins);

    public Admin findAdminById(Integer id);
}
