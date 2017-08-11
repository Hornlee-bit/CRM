package com.zhidi.manage.service;

import com.zhidi.base.service.BaseService;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.vo.AnnouncementVO;
import com.zhidi.util.Pager;

/**
 * Created by Administrator on 2017-08-01.
 */
public interface AnnouncementService extends BaseService<Announcement,String> {

    Pager getAnnouncementListByPage(Integer pageNumber, Integer pageSize , AnnouncementVO announcement);
    AnnouncementVO getAnnouncementById(String id);
}
