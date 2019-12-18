package dao;

import pojo.Focus;

import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
public interface FocusMapper {

    public List<Focus> getFocusByUserId(Integer user_id);

    public void deleteFocusByUserIdAndGoodsId(Integer goods_id,Integer user_id);

    public void addFocusByUserIdAndGoodsId(Integer goods_id, Integer user_id);

}
