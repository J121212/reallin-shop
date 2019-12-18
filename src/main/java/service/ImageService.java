package service;

import pojo.Image;

import java.util.List;

/**
 * Created by pc on 2019/10/9.
 */
public interface ImageService {

    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId);

    int insert(Image record);
}
