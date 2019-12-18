package service.impl;

import com.github.pagehelper.PageHelper;
import dao.OrdersMapper;
import org.springframework.stereotype.Service;
import pojo.Orders;
import service.OrdersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/1.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Resource
   private OrdersMapper ordersMapper;

    public int getOrdersNum() {
        List<Orders> orders = ordersMapper.getOrdersList();
        return orders.size();
    }

    public List<Orders> getPageOrders(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> list =ordersMapper.getOrdersList();
        return list;
    }

    public Orders getOrdersById(int ordersId) {
        Orders orders = ordersMapper.selectById(ordersId);
        return orders;
    }

    public void updateByPrimaryKey(Integer id, Orders orders) {
        orders.setId(id);
        this.ordersMapper.updateByPrimaryKey(orders);

    }

    public void deleteOrdersByPrimaryKeys(int id) {
        ordersMapper.deleteByPrimaryKeys(id);
    }

    public List<Orders> getPageOrdersByOrders(Long orderNum, String orderInformation, Integer orderState, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Orders> orders = ordersMapper.getPageOrdersByOrders(orderNum,orderInformation,orderState);
        return orders;
    }

    public List<Orders> getOrdersByUserId(Integer user_id) {
        List<Orders> orders=ordersMapper.selectOrdersByUserId(user_id);
        return orders;
    }

    public List<Orders> getOrdersByUserAndGoods(Integer user_id) {
        List<Orders> ordersOfSell=ordersMapper.selectOrdersByUserAndGoods(user_id);
        return ordersOfSell;
    }

    public void addOrders(Orders orders) {
        // TODO Auto-generated method stub

        ordersMapper.addOrders(orders);

    }

    public void deliverByOrderNum(Integer orderNum) {
        ordersMapper.deliverByOrderNum(orderNum);
    }

    public void receiptByOrderNum(Integer orderNum) {
        // TODO Auto-generated method stub
        ordersMapper.receiptByOrderNum(orderNum);

    }
}
