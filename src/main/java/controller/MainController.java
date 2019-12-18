package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserService;
import util.UserGrid;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */

@Controller
public class MainController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/userList")
    @ResponseBody
    public UserGrid getUserList(@RequestParam("current") int current, @RequestParam("rowCount") int rowCount) {
        int total = userService.getUserNum();
        List<User> list = userService.getPageUser(current, rowCount);
        UserGrid userGrid = new UserGrid();
        userGrid.setCurrent(current);
        userGrid.setRowCount(rowCount);
        userGrid.setRows(list);
        userGrid.setTotal(total);
        return userGrid;
    }
}
