package service.impl;

import dao.NoticeMapper;
import org.springframework.stereotype.Service;
import pojo.Notice;
import service.NoticeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2019/10/13.
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;


    public List<Notice> getNoticeList() {
        return noticeMapper.getNoticeList();
    }

    public void insertSelective(Notice notice) {
        noticeMapper.insertSelective(notice);

    }
}
