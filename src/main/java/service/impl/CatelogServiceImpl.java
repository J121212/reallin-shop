package service.impl;

import dao.CatelogMapper;
import org.springframework.stereotype.Service;
import pojo.Catelog;
import service.CatelogService;

import javax.annotation.Resource;

/**
 * Created by pc on 2019/10/11.
 */
@Service
public class CatelogServiceImpl implements CatelogService {
@Resource
    CatelogMapper catelogMapper;
    public Catelog selectByPrimaryKey(Integer id) {
        Catelog catelog = catelogMapper.selectByPrimaryKey(id);
        return catelog;
    }

    public int updateCatelogNum(Integer id, Integer number) {
        return catelogMapper.updateCatelogNum(id,number);
    }
}
