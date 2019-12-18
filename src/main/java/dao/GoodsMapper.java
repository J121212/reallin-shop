package dao;

import org.apache.ibatis.annotations.Param;
import pojo.CommentExtend;
import pojo.Comments;
import pojo.Goods;

import java.util.List;

/**
 * Created by pc on 2019/9/28.
 */
public interface GoodsMapper {

List<Goods> getGoodsList();

    Goods selectById(Integer goodsId);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int deleteByPrimaryKey(Integer id);

    int deleteByPrimaryKeys(Integer id);

    List<Goods> getPageGoodsByGoods(@Param("id") Integer id,@Param("name") String name,@Param("status") Integer status);

    public List<Goods> selectOrderByDate(@Param("limit")Integer limit);

    public List<Goods> selectByCatelogOrderByDate(@Param("catelogId")Integer catelogId,@Param("limit")Integer limit);

    List<Goods> searchGoods(@Param("name") String name,@Param("describle") String describle);

    public List<Goods> selectByStr(@Param("limit")Integer limit,@Param("name") String name,@Param("describle") String describle);

    public List<Goods> selectByCatelog(@Param("catelog_id") Integer catelog_id,@Param("name") String name,@Param("describle") String describle);

    Goods selectByPrimaryKey(Integer id);

    CommentExtend selectCommentsByGoodsId(@Param("id")Integer id);

    public void addComments(Comments comments);

    int insert(Goods record);

    int updateGoodsByGoodsId(Goods goods);

    public List<Goods> getGoodsByUserId(Integer user_id);


}
