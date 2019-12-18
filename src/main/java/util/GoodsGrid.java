package util;

import pojo.Goods;

import java.util.List;

/**
 * Created by pc on 2019/9/28.
 */
public class GoodsGrid {
        private int current;
    private int rowCurrent;
    private int total;
    private List<Goods> rows;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getRowCurrent() {
        return rowCurrent;
    }

    public void setRowCurrent(int rowCurrent) {
        this.rowCurrent = rowCurrent;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Goods> getRows() {
        return rows;
    }

    public void setRows(List<Goods> rows) {
        this.rows = rows;
    }
}
