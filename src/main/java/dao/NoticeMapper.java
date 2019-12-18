package dao;

import pojo.Notice;

import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
public interface NoticeMapper {

    public List<Notice> getNoticeList();

    int insertSelective(Notice record);
}
