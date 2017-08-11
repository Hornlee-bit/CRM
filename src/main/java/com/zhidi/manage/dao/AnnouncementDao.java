package com.zhidi.manage.dao;

import com.zhidi.base.dao.BaseDao;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.vo.AnnouncementVO;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface AnnouncementDao extends BaseDao<Announcement ,String>{

    List<Announcement> getAnnouncementListByPage(Integer pageNumber, Integer pageSize, AnnouncementVO announcement);
    Integer getSize(AnnouncementVO announcement);
}
