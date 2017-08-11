package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.AnnouncementDao;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.service.AnnouncementService;
import com.zhidi.manage.vo.AnnouncementVO;
import com.zhidi.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Service
public class AnnouncementServiceImpl extends BaseServiceImpl<Announcement,String> implements AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;
    @Autowired
    private void setAnnouncementDao(AnnouncementDao announcementDao){
        super.setBaseDao(announcementDao);
    }

    @Override
    public Pager getAnnouncementListByPage(Integer pageNumber, Integer pageSize, AnnouncementVO announcement) {
        List<Announcement> announcementList = announcementDao.getAnnouncementListByPage(pageNumber,pageSize,announcement);
        List<AnnouncementVO> announcementVOS = new ArrayList<>();
        if (announcementList != null && !announcementList.isEmpty()) {
            for (Announcement annou : announcementList) {
                AnnouncementVO announcementVO = AnnouncementVO.fromAnnoucement(annou);
                announcementVOS.add(announcementVO);
            }
        }
        //查询数据总数
        Integer totalRows = announcementDao.getSize(announcement);
        Pager pager = new Pager();
        pager.setList(announcementVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public AnnouncementVO getAnnouncementById(String id) {
        Announcement announcement = announcementDao.get(id);
        return AnnouncementVO.fromAnnoucement(announcement);
    }
}
