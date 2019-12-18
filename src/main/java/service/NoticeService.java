package service;

import pojo.Notice;

import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
public interface NoticeService {

    List<Notice> getNoticeList();

    public void insertSelective(Notice notice);
}
