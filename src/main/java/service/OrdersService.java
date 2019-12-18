package service;

import pojo.Orders;

import java.util.List;

/**
 * Created by pc on 2019/10/1.
 */
public interface OrdersService {

    public int getOrdersNum();

    public List<Orders> getPageOrders(int pageNum, int pageSize);

    public Orders getOrdersById(int ordersId);

    public void updateByPrimaryKey(Integer id, Orders orders);

    public void deleteOrdersByPrimaryKeys(int id);

    public List<Orders> getPageOrdersByOrders(Long orderNum, String orderInformation, Integer orderState, int pageNum,
                                              int pageSize);

    public List<Orders> getOrdersByUserId(Integer user_id);

    public List<Orders> getOrdersByUserAndGoods(Integer user_id);

    public void addOrders(Orders orders);

    public void deliverByOrderNum(Integer orderNum);

    public void receiptByOrderNum(Integer orderNum);
}
