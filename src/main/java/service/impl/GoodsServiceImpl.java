package service.impl;

import com.github.pagehelper.PageHelper;
import dao.GoodsMapper;
import org.springframework.stereotype.Service;
import pojo.CommentExtend;
import pojo.Comments;
import pojo.Goods;
import service.GoodsService;
import util.DateUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/9/28.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;


    public int getGoodsNum() {
        List<Goods> goods=goodsMapper.getGoodsList();
        return goods.size();

    }

    public List<Goods> getPageGoods(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list =goodsMapper.getGoodsList();
        return list;
    }

    public Goods getGoodsById(Integer goodsId) {
        Goods goods=goodsMapper.selectById(goodsId);
        return goods;
    }

    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId, Goods goods) {
        goods.setId(goodsId);
        goodsMapper.updateByPrimaryKeyWithBLOBs(goods);
    }

    public void deleteGoodsByPrimaryKey(Integer id) {
        goodsMapper.deleteByPrimaryKey(id);
    }

    public void deleteGoodsByPrimaryKeys(Integer id) {
            goodsMapper.deleteByPrimaryKeys(id);
    }

    public List<Goods> getPageGoodsByGoods(Integer id, String name, Integer status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> list =goodsMapper.getPageGoodsByGoods(id,name,status);
        return list;
    }

    public List<Goods> getGoodsOrderByDate(Integer limit) {
        List<Goods> goodsList = goodsMapper.selectOrderByDate(limit);
        return goodsList;
    }

    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId, Integer limit) {
        List<Goods> goodsList = goodsMapper.selectByCatelogOrderByDate(catelogId , limit);
        return goodsList;
    }

    public List<Goods> searchGoods(String name, String describle) {
        List<Goods> goods = goodsMapper.searchGoods(name,describle);
        return  goods;
    }

    public List<Goods> getGoodsByStr(Integer limit, String name, String describle) {
        List<Goods> goods = goodsMapper.selectByStr(limit, name, describle);
        return goods;
    }

    public List<Goods> getGoodsByCatelog(Integer id, String name, String describle) {
        List<Goods> goods = goodsMapper.selectByCatelog(id,name,describle);
        return goods;
    }

    public Goods getGoodsByPrimaryKey(Integer goodsId) {
        return null;
    }

    public CommentExtend selectCommentsByGoodsId(Integer id) {
        return goodsMapper.selectCommentsByGoodsId(id);
    }

    public void addComments(Comments comments) {
        goodsMapper.addComments(comments);
    }

    public int addGood(Goods goods, Integer duration) {
        String startTime = DateUtil.getNowDay();
        String endTime = DateUtil.getLastTime(startTime, duration);
        String polishTime = startTime;
        //添加上架时间，下架时间，擦亮时间
        goods.setPolishTime(polishTime);
        goods.setEndTime(endTime);
        goods.setStartTime(startTime);
        return goodsMapper.insert(goods);
    }

    public void updateGoodsByGoodsId(Goods goods) {
        goodsMapper.updateGoodsByGoodsId(goods);
    }

    public List<Goods> getGoodsByUserId(Integer user_id) {
        List<Goods> goodsList = goodsMapper.getGoodsByUserId(user_id);
        return goodsList;
    }


}
