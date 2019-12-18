package service.impl;

import dao.FocusMapper;
import org.springframework.stereotype.Service;
import pojo.Focus;
import service.FocusService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
@Service
public class FocusServiceImpl implements FocusService {


    @Resource
    private FocusMapper focusMapper;
    public List<Focus> getFocusByUserId(Integer user_id) {
        List<Focus> focusList = focusMapper.getFocusByUserId(user_id);

        return focusList;
    }

    public void deleteFocusByUserIdAndGoodsId(Integer goods_id, Integer user_id) {
        focusMapper.deleteFocusByUserIdAndGoodsId(goods_id, user_id);
    }

    public void addFocusByUserIdAndId(Integer goods_id, Integer user_id) {
        focusMapper.addFocusByUserIdAndGoodsId(goods_id,user_id);
    }
}
