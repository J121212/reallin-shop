package service;

import pojo.Focus;

import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
public interface FocusService {

    public List<Focus> getFocusByUserId(Integer user_id);

    public void deleteFocusByUserIdAndGoodsId(Integer goods_id,Integer user_id);

    public void addFocusByUserIdAndId(Integer goods_id, Integer user_id);
}
