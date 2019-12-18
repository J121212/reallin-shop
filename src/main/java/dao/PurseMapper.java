package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Purse;

import java.util.List;

/**
 * Created by pc on 2019/10/2.
 */
public interface PurseMapper {

    public void updatePurseByuserId(Integer userId, Float balance);

    public void updatePurseOfdel(Integer userId, Float balance);

    public List<Purse> selectPurseList();

    public List<Purse> getPagePurseByPurse(@Param("userId")Integer userId, @Param("state")Integer state);

    public Purse selectPurseById(int id);

    public void updatePurseById(Purse purse);

    public void updateByPrimaryKey(Purse purse);

    public void addPurse(Integer userId);


    public void updatePurse(Purse purse);
}
