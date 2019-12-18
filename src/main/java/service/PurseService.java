package service;

import pojo.Purse;

import java.util.List;

/**
 * Created by pc on 2019/10/2.
 */
public interface PurseService {

    public void updatePurseByuserId(Integer userId, Float balance);

    public void updatePurseOfdel(Integer user_id, Float balance);

    public int getPurseNum();

    public List<Purse> getPagePurse(int pageNum, int pageSize);

    public List<Purse> getPagePurseByPurse(Integer userId,Integer state, int pageNum, int pageSize);

    public Purse getPurseById(int id);

    public void updatePursePassById(Integer id, Purse purse);

    public void updatePurseRefuseById(Integer id,Purse purse);

    public void updateByPrimaryKey(Integer id, Purse purse);

    public Purse getPurseByUserId(Integer user_id);

    public void addPurse(Integer userId);

    public void updatePurse(Purse purse);

}
