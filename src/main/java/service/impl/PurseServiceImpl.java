package service.impl;

import com.github.pagehelper.PageHelper;
import dao.PurseMapper;
import org.springframework.stereotype.Service;
import pojo.Purse;
import service.PurseService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/2.
 */
@Service
public class PurseServiceImpl implements PurseService {
    @Resource
    private PurseMapper purseMapper;


    public void updatePurseByuserId(Integer userId, Float balance) {
        purseMapper.updatePurseByuserId(userId,balance);

    }

    public void updatePurseOfdel(Integer userId, Float balance) {
        purseMapper.updatePurseOfdel(userId, balance);

    }

    public int getPurseNum() {
        List<Purse> purse= purseMapper.selectPurseList();
        return purse.size();
    }

    public List<Purse> getPagePurse(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Purse> purse =purseMapper.selectPurseList();
        return purse;
    }

    public List<Purse> getPagePurseByPurse(Integer userId, Integer state, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Purse> purse =purseMapper.getPagePurseByPurse(userId,state);
        return purse;
    }

    public Purse getPurseById(int id) {
        return purseMapper.selectPurseById(id);
    }

    public void updatePursePassById(Integer id, Purse purse) {
        purse.setId(id);
        purseMapper.updatePurseById(purse);
    }

    public void updatePurseRefuseById(Integer id, Purse purse) {
        purse.setId(id);
        purseMapper.updatePurseById(purse);
    }

    public void updateByPrimaryKey(Integer id, Purse purse) {
        purse.setId(id);
        purseMapper.updateByPrimaryKey(purse);
    }

    public Purse getPurseByUserId(Integer user_id) {
        return null;
    }

    public void addPurse(Integer userId) {
        purseMapper.addPurse(userId);
    }

    public void updatePurse(Purse purse) {
        purseMapper.updatePurse(purse);
    }
}
