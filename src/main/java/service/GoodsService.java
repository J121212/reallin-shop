package service;

import pojo.CommentExtend;
import pojo.Comments;
import pojo.Goods;

import java.util.List;

/**
 * Created by pc on 2019/9/28.
 */
public interface GoodsService {
    public int getGoodsNum();

    public List<Goods> getPageGoods(int pageNum, int pageSize);

    public Goods getGoodsById(Integer goodsId);

    public void updateGoodsByPrimaryKeyWithBLOBs(int goodsId ,Goods goods);

    public void deleteGoodsByPrimaryKey(Integer id);//更新

    public void deleteGoodsByPrimaryKeys(Integer id);//删除


    public List<Goods> getPageGoodsByGoods(Integer id, String name, Integer status, int pageNum, int pageSize);

    public List<Goods> getGoodsOrderByDate(Integer limit);


    public List<Goods> getGoodsByCatelogOrderByDate(Integer catelogId,Integer limit);

    List<Goods> searchGoods(String name, String describle);

    public List<Goods> getGoodsByStr(Integer limit,String name,String describle);

    public List<Goods> getGoodsByCatelog(Integer id,String name,String describle);

    public Goods getGoodsByPrimaryKey(Integer goodsId);

    public CommentExtend selectCommentsByGoodsId(Integer id);

    public void addComments(Comments comments);

    public int addGood(Goods goods , Integer duration);

    public void updateGoodsByGoodsId(Goods goods);

    public List<Goods> getGoodsByUserId(Integer user_id);
}
