package com.zhidi.manage.service.impl;

import com.zhidi.base.service.impl.BaseServiceImpl;
import com.zhidi.manage.dao.BusinessDao;
import com.zhidi.manage.entity.Business;
import com.zhidi.manage.service.BusinessService;
import com.zhidi.manage.vo.BusinessVO;
import com.zhidi.util.Pager;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017-08-04.
 */
@Service
public class BusinessServiceImpl extends BaseServiceImpl<Business,String> implements BusinessService {
    @Autowired
    private BusinessDao businessDao;
    @Autowired
    private void setBusinessDao(BusinessDao businessDao){
        super.setBaseDao(businessDao);
    }

    @Override
    public Pager getBusinessByPage(Integer pageNumber, Integer pageSize,String condition,String searchText) {
        List<Business> businessList = businessDao.getBusinessListByPage(pageNumber,pageSize,condition,searchText);
        List<BusinessVO> businessVOS = new ArrayList<>();
        if(businessList!=null&&!businessList.isEmpty()) {
            for (Business business : businessList) {
                BusinessVO businessVO = BusinessVO.fromBusiness(business);
                businessVOS.add(businessVO);
            }
        }
        Integer totalRows = businessDao.getSize(condition,searchText);
        Pager pager = new Pager();
        pager.setList(businessVOS);
        pager.setPageNumber(pageNumber);
        pager.setPageSize(pageSize);
        pager.setTotalRows(totalRows);
        pager.setTotalPage(pager.getTotalPage());
        return pager;
    }

    @Override
    public List<BusinessVO> getAllBusiness() {
        List<Business> list = businessDao.getAll();
        List<BusinessVO> businessVOS = new ArrayList<>();
        if(list!=null && !list.isEmpty()){
            for(Business business : list){
                BusinessVO businessVO = BusinessVO.fromBusiness(business);
                businessVOS.add(businessVO);
            }
            return businessVOS;
        }
        return null;
    }
}
