package com.zhidi.manage.dao.impl;

import com.zhidi.base.dao.impl.BaseDaoImpl;
import com.zhidi.manage.dao.AnnouncementDao;
import com.zhidi.manage.entity.Announcement;
import com.zhidi.manage.vo.AnnouncementVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017-08-01.
 */
@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement,String> implements AnnouncementDao {

    @Override
    public List<Announcement> getAnnouncementListByPage(Integer pageNumber, Integer pageSize, AnnouncementVO announcement) {
        String hql;
        if(announcement==null){
            hql = "from Announcement a left join fetch a.department d left join fetch a.user";
        }else {
            hql = "from Announcement a left join fetch " +
                    "a.department d left join fetch a.user " +
                    "where a.title like '%" + announcement.getTitle() + "%' and d.name like '%"+announcement.getDepartmentname()+"%'";
        }
        return this.getListByPage(pageNumber,pageSize,hql,new String[]{});
    }

    @Override
    public Integer getSize(AnnouncementVO announcement) {
        String hql;
        if(announcement==null){
            hql = "from Announcement a left join fetch a.department d left join fetch a.user";
        }else {
            hql = "from Announcement a left join fetch " +
                    "a.department d left join fetch a.user " +
                    "where a.title like '%" + announcement.getTitle() + "%' and d.name like '%"+announcement.getDepartmentname()+"%'";
        }
        return this.getSize(hql);
    }
}
