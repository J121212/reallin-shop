package service.impl;

import dao.ImageMapper;
import org.springframework.stereotype.Service;
import pojo.Image;
import service.ImageService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/9.
 */
@Service
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageMapper imageMapper;

    public List<Image> getImagesByGoodsPrimaryKey(Integer goodsId) {
        List<Image> image = imageMapper.selectByGoodsPrimaryKey(goodsId);
        return image;
    }

    public int insert(Image record) {
        return imageMapper.insert(record);
    }
}
