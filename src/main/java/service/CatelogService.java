package service;

import pojo.Catelog;

/**
 * Created by pc on 2019/10/11.
 */
public interface CatelogService {

    Catelog selectByPrimaryKey(Integer id);

    int updateCatelogNum(Integer id,Integer number);
}
