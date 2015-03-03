package com.xplore.web.service;

import com.xplore.web.dao.ServiceDao;
import com.xplore.web.domain.Service;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by damen on 2014/12/20.
 */
@org.springframework.stereotype.Service
@Transactional
public class ServiceService {

    @Autowired
    ServiceDao serviceDao;

    public Service getById(Integer id) {
        return serviceDao.get(id);
    }

    public Page<Service> pagedList(Page<Service> page) {

        page.setResult(serviceDao.pagedList(page).getResult());
        page.setTotalCount(serviceDao.getTotalCount());

        return page;
    }

    public void save(Service service) {
        serviceDao.save(service);
    }

    public void del(Integer id) {
        serviceDao.delete(id);
    }

    public List<Service> recent() {
        return serviceDao.getRecent(6);

    }


    public int getTotalCount() {
        return serviceDao.getTotalCount();
    }

    public Service getLeftSiblingById(Integer id) {
        return serviceDao.getLeftSiblingByid(id);
    }
    public Service getRightSiblingById(Integer id) {
        return serviceDao.getRightSiblingByid(id);
    }
}
