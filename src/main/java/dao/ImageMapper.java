package dao;

import pojo.Image;

import java.util.List;

/**
 * Created by pc on 2019/10/9.
 */
public interface ImageMapper {
    List<Image> selectByGoodsPrimaryKey(Integer goodsId);

    int insert(Image record);

}
