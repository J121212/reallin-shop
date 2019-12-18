package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Catelog;

/**
 * Created by pc on 2019/10/11.
 */
public interface CatelogMapper {

    Catelog selectByPrimaryKey(Integer id);

    int updateCatelogNum(@Param("id") Integer id, @Param("number") Integer number);
}
