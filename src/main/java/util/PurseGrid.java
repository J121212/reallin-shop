package util;

import pojo.Purse;

import java.util.List;

/**
 * Created by pc on 2019/10/2.
 */
public class PurseGrid {

    private int current;//当前页面号
    private int rowCount;//每页行数
    private int total;//总行数
    private List<Purse> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Purse> getRows() {
        return rows;
    }

    public void setRows(List<Purse> rows) {
        this.rows = rows;
    }
}
