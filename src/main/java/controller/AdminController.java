package controller;

import com.sun.corba.se.spi.servicecontext.UEInfoServiceContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pojo.*;
import service.*;
import util.GoodsGrid;
import util.OrdersGrid;
import util.PurseGrid;
import util.UserGrid;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by pc on 2019/9/22.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;


    @Resource
    private UserService userService;

    @Resource
    private GoodsService goodsService;

    @Resource
    private OrdersService ordersService;


    @Resource
    private PurseService purseService;

    @RequestMapping(value = "/index",method = RequestMethod.POST)
    public String login(HttpServletRequest request, Admin admins){
        Admin admin=adminService.login(admins.getAccount(), admins.getPassword());
        if(admin!=null){
            request.getSession().setAttribute("admin",admin);
            return "/admin/index";
        }
            return "/admin/login";
    }

    @RequestMapping(value = "/indexs")
    public String indexs(HttpServletRequest request) {
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        if (admin != null) {
            request.getSession().setAttribute("admin", admin);
            return "/admin/index";
        }
        return "/admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/admin/login";
    }


    @RequestMapping("/info")
    @ResponseBody
    public ModelAndView getInfo(HttpServletRequest request){
        Admin admin=(Admin) request.getSession().getAttribute("admin");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("admin/info");
        return modelAndView;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public ModelAndView getModify(HttpServletRequest request){
        Admin admin=(Admin)request.getSession().getAttribute("admin");
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("admin",admin);
        modelAndView.setViewName("admin/modify");
        return modelAndView;
    }

        @RequestMapping("/changemessage")
    @ResponseBody
    public ModelAndView changemessage(HttpServletRequest request,Admin admin){
            String pwd=request.getParameter("password1");
            String usn=request.getParameter("username1");
            ModelAndView modelAndView=new ModelAndView();
            Admin admins=(Admin)request.getSession().getAttribute("admin");
            if(admin.getPassword().equals(admins.getPassword())&&admin.getUserName().equals(admins.getUserName())){
                admins.setPassword(pwd);
                admins.setUserName(usn);
                adminService.updateAdmin(admins);
            }else {
                modelAndView.addObject("msg","修改失败");
                modelAndView.setViewName("admin/modify");
                return modelAndView;
            }
            modelAndView.setViewName("admin/login");
            return modelAndView;

        }

@RequestMapping("/userList")
    @ResponseBody
    public ModelAndView getUserList(@RequestParam("pageNum") int pageNum){
    ModelAndView modelAndView=new ModelAndView();
    int pageSize=10;
    int total= userService.getUserNum();
    List<User> rows=userService.getPageUser(pageNum,pageSize);
    UserGrid userGrid=new UserGrid();
    userGrid.setCurrent(pageNum);
    userGrid.setRowCount(pageSize);
    userGrid.setRows(rows);
    userGrid.setTotal(total);
    modelAndView.addObject("userGrid",userGrid);
    modelAndView.setViewName("admin/user/user_list");
    return modelAndView;


}
    @RequestMapping("/getUser")
    @ResponseBody
public User getUser(HttpServletRequest request){
String id=request.getParameter("id");
        User user=userService.getUserById(Integer.parseInt(id));
        return user;
    }

    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(User user){
        User users=userService.selectByPrimaryKey(user.getId());
        user.setPassword(users.getPassword());
        try {
            userService.updateUserName(user);
        } catch (Exception e) {
            return "{\"success\":false,\"msg\":\"保存失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"保存成功!\"}";

    }

    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    @ResponseBody
    public String deleteUser(@RequestParam(value = "ids[]") String []ids){
        try {
            for (int i = 0; i < ids.length; i++) {
                userService.deleteUserById(ids[i]);
            }
        } catch (Exception e) {
            return "{\"success\":false,\"msg\":\"删除失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"删除成功!\"}";
    }


    @RequestMapping(value = "/searchUser", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchUser(User user){
        ModelAndView modelAndView=new ModelAndView();
        int pageNum=1;
        int pageSize=10;
        int total=userService.getUserNum();
        String phone=user.getPhone();
        String username=user.getUsername();
        String wechat=user.getWechat();
        List<User> rows=userService.getPageUserByUser(phone,username,wechat,pageNum,pageSize);
        UserGrid userGrid=new UserGrid();
        userGrid.setCurrent(pageNum);
        userGrid.setRowCount(pageSize);
        userGrid.setRows(rows);
        userGrid.setTotal(total);
        User searchuser=new User();
        searchuser.setPhone(phone);
        searchuser.setUsername(username);
        searchuser.setWechat(wechat);
        modelAndView.addObject("userGrid",userGrid);
        modelAndView.addObject("searchuser",searchuser);
        modelAndView.setViewName("admin/user/user_list");

    return modelAndView;
    }

    @RequestMapping("/goodsList")
    @ResponseBody
    public ModelAndView getGoodsList(@RequestParam("pageNum") int pageNum){
        ModelAndView modelAndView=new ModelAndView();
        int pageSize=10;
        int total=goodsService.getGoodsNum();
        List<Goods> rows=goodsService.getPageGoods(pageNum,pageSize);
        GoodsGrid goodsGrid=new GoodsGrid();
        goodsGrid.setCurrent(pageNum);
        goodsGrid.setRowCurrent(pageSize);
        goodsGrid.setRows(rows);
        goodsGrid.setTotal(total);
        modelAndView.addObject("goodsGrid", goodsGrid);
        modelAndView.setViewName("admin/goods/goods_list");
        return modelAndView;
    }


    @RequestMapping("/getGoods")
    @ResponseBody
    public Goods getGoods(HttpServletRequest request){
        String id=request.getParameter("id");
        Goods goods=goodsService.getGoodsById(Integer.parseInt(id));
        return goods;
    }

    //记得看
    @RequestMapping(value = "/updateGoods", method = RequestMethod.POST)
    @ResponseBody
    public String updateGoods(HttpServletRequest request,Goods goods){
        int id=goods.getId();
        Goods oldGoods = goodsService.getGoodsById(id);
        goods.setUserId(oldGoods.getUserId());
        goods.setPolishTime(oldGoods.getPolishTime());
        goods.setEndTime(oldGoods.getEndTime());
        try {
            goodsService.updateGoodsByPrimaryKeyWithBLOBs(goods.getId(), goods);
        } catch (Exception e) {
            return "{\"success\":false,\"msg\":\"保存失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"保存成功!\"}";
    }

@RequestMapping(value = "/deleteGoods",method = RequestMethod.POST)
    @ResponseBody
    public String deleteGoods(HttpServletRequest request,@RequestParam(value = "ids[]") String[] ids){
    try {
        for (int i = 0; i < ids.length; i++) {
            goodsService.deleteGoodsByPrimaryKeys(Integer.parseInt(ids[i]));
        }
    } catch (Exception e) {
        return "{\"success\":false,\"msg\":\"删除失败!\"}";
    }
    return "{\"success\":true,\"msg\":\"删除成功!\"}";

}


    @RequestMapping(value = "/searchGoods",method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchGoods(Goods goods){
        ModelAndView mv=new ModelAndView();
        int pageNum=1;
        int pageSize=10;
        int total=goodsService.getGoodsNum();
        Integer id =goods.getId();
        String name=goods.getName();
        Integer status=goods.getStatus();
        List<Goods> rows=goodsService.getPageGoodsByGoods(id,name,status,pageNum,pageSize);
        GoodsGrid goodsGrid = new GoodsGrid();
        Goods searchgoods = new Goods();
        searchgoods.setId(id);
        searchgoods.setName(name);
        searchgoods.setStatus(status);
        goodsGrid.setCurrent(pageNum);
        goodsGrid.setRowCurrent(pageSize);
        goodsGrid.setRows(rows);
        goodsGrid.setTotal(total);
        mv.addObject("goodsGrid", goodsGrid);
        mv.addObject("searchgoods", searchgoods);
        mv.setViewName("admin/goods/goods_list");
        return mv;
    }


    @RequestMapping(value = "/ordersList")
    @ResponseBody
    public ModelAndView getOrdersList(@RequestParam("pageNum") int pageNum) {
        ModelAndView modelAndView = new ModelAndView();
        int pageSize = 10;
        int total = ordersService.getOrdersNum();
        List<Orders> rows = ordersService.getPageOrders(pageNum, pageSize);
        OrdersGrid ordersGrid = new OrdersGrid();
        ordersGrid.setCurrent(pageNum);
        ordersGrid.setRowCount(pageSize);
        ordersGrid.setRows(rows);
        ordersGrid.setTotal(total);
        modelAndView.addObject("ordersGrid", ordersGrid);
        modelAndView.setViewName("admin/orders/orders_list");
        return modelAndView;
    }

    @RequestMapping("/getOrders")
    @ResponseBody
    public Orders getOrders(HttpServletRequest request) {
        String id = request.getParameter("id");
        Orders orders = ordersService.getOrdersById(Integer.parseInt(id));
        return orders;
    }

    @RequestMapping(value = "/updateOrders", method = RequestMethod.POST)
    @ResponseBody
    public String updateOrders(HttpServletRequest request, Orders orders) {
        int id = orders.getId();
        Orders oldorders = ordersService.getOrdersById(id);
        orders.setGoodsId(oldorders.getGoodsId());
        orders.setUserId(oldorders.getUserId());
        Goods goods=goodsService.getGoodsById(oldorders.getGoods().getId());
        if (oldorders.getOrderState() != orders.getOrderState()) {
            Float balance = orders.getOrderPrice();
            if (orders.getOrderState() == 3) {
                purseService.updatePurseByuserId(goods.getUserId(), balance);
            } else {
                purseService.updatePurseOfdel(goods.getUserId(), balance);
            }
        }
        try {
            ordersService.updateByPrimaryKey(id, orders);
        } catch (Exception e) {
            return "{\"success\":false,\"msg\":\"保存失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"保存成功!\"}";
    }


    @RequestMapping(value = "/deleteOrders", method = RequestMethod.POST)
    @ResponseBody
    public String deleteOrders(HttpServletRequest request, @RequestParam(value = "ids[]") String[] ids) {
        try {
            for (int i = 0; i < ids.length; i++) {
                ordersService.deleteOrdersByPrimaryKeys(Integer.parseInt(ids[i]));
            }
        } catch (Exception e) {
            return "{\"success\":false,\"msg\":\"删除失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"删除成功!\"}";
    }


    @RequestMapping(value = "/searchOrders", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchOrders(HttpServletRequest request, Orders orders) {
        ModelAndView mv = new ModelAndView();
        int pageNum = 1;
        int pageSize = 10;
        int total = ordersService.getOrdersNum();
        Long orderNum = orders.getOrderNum();
        String orderInformation = orders.getOrderInformation();
        Integer orderState = orders.getOrderState();
        List<Orders> rows = ordersService.getPageOrdersByOrders(orderNum, orderInformation, orderState, pageNum, pageSize);
        OrdersGrid ordersGrid = new OrdersGrid();
        Orders searchorders = new Orders();
        searchorders.setOrderNum(orderNum);
        searchorders.setOrderInformation(orderInformation);
        searchorders.setOrderState(orderState);
        ordersGrid.setCurrent(pageNum);
        ordersGrid.setRowCount(pageSize);
        ordersGrid.setRows(rows);
        ordersGrid.setTotal(total);
        mv.addObject("ordersGrid", ordersGrid);
        mv.addObject("searchorders", searchorders);
        mv.setViewName("admin/orders/orders_list");
        return mv;
    }

    @RequestMapping("/purseList")
    @ResponseBody
    public ModelAndView getPurseList(HttpServletRequest request){
        int pageNum=Integer.parseInt(request.getParameter("pageNum"));
        ModelAndView modelAndView = new ModelAndView();
        int pageSize = 10;
        int total = purseService.getPurseNum();
        List<Purse> rows = purseService.getPagePurse(pageNum, pageSize);
        PurseGrid purseGrid = new PurseGrid();
        purseGrid.setCurrent(pageNum);
        purseGrid.setRowCount(pageSize);
        purseGrid.setRows(rows);
        purseGrid.setTotal(total);
        modelAndView.addObject("purseGrid", purseGrid);
        modelAndView.setViewName("admin/purse/purse_list");
        return modelAndView;
    }

    @RequestMapping(value = "/searchPurse", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView searchPurse(HttpServletRequest request, Purse purse) {
        ModelAndView mv = new ModelAndView();
        int pageNum = 1;
        int pageSize = 10;
        int total = purseService.getPurseNum();
        Integer userId = purse.getUserId();
        Integer state=purse.getState();
        List<Purse> rows = purseService.getPagePurseByPurse(userId,state, pageNum, pageSize);
        PurseGrid purseGrid = new PurseGrid();
        Purse searchpurse = new Purse();
        searchpurse.setUserId(userId);
        searchpurse.setState(state);
        purseGrid.setCurrent(pageNum);
        purseGrid.setRowCount(pageSize);
        purseGrid.setRows(rows);
        purseGrid.setTotal(total);
        mv.addObject("purseGrid", purseGrid);
        mv.addObject("searchpurse", searchpurse);
        mv.setViewName("admin/purse/purse_list");
        return mv;
    }

    @RequestMapping(value = "/getPurse")
    @ResponseBody
    public Purse getPurse(HttpServletRequest request) {
        String id = request.getParameter("id");
        Purse purse = purseService.getPurseById(Integer.parseInt(id));
        return purse;
    }

    @RequestMapping(value = "/updatePursePass", method = RequestMethod.POST)
    @ResponseBody
    public String updatePursePass(Purse purse) {
        Float balance=purse.getBalance();
        purse.setState(2);
        try {
            if(purse.getRecharge()!=null){//充值 充值金额=null 当前金额=当前金额+充值金额
                Float recharge=purse.getRecharge();
                Float balanceRecharge=balance+recharge;
                purse.setBalance(balanceRecharge);
                purseService.updatePursePassById(purse.getId(),purse);
            }if(purse.getWithdrawals()!=null) {//提现
                Float withdrawals=purse.getWithdrawals();
                Float balanceWithdrawals=balance-withdrawals;
                purse.setBalance(balanceWithdrawals);
                purseService.updatePurseRefuseById(purse.getId(),purse);
            }
        }
        catch (Exception e) {
            return "{\"success\":true,\"msg\":\"审核失败，请核对金额!\"}";
        }
        return "{\"success\":true,\"msg\":\"审核成功!\"}";
    }

    @RequestMapping(value = "/updatePurseRefuse", method = RequestMethod.POST)
    @ResponseBody
    public String updatePurseRefuse(Purse purse) {
        purse.setState(1);
        try {

            purseService.updatePurseRefuseById(purse.getId(),purse);

        }
        catch (Exception e) {
            return "{\"success\":true,\"msg\":\"审核失败!\"}";
        }
        return "{\"success\":true,\"msg\":\"审核成功!\"}";
    }

    @RequestMapping(value = "/updatePurseState", method = RequestMethod.GET)
    public void updatePurseState(HttpServletRequest request) {
        Integer id=Integer.parseInt(request.getParameter("id"));
        Purse purse= purseService.getPurseById(id);
        purse.setState(null);
        this.purseService.updateByPrimaryKey(id,purse);//修改state为null
    }

}
