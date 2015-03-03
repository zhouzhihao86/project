package com.xplore.web.service;

import com.xplore.web.dao.PartyDao;
import com.xplore.web.domain.Party;
import com.xplore.web.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by damen on 2014/12/20.
 */
@Service
@Transactional
public class PartyService {

    @Autowired
    PartyDao partyDao;

    public Party getById(Integer id) {
        return partyDao.get(id);
    }

    public Page<Party> pagedList(Page<Party> page) {

        page.setResult(partyDao.pagedList(page).getResult());
        page.setTotalCount(partyDao.getTotalCount());

        return page;
    }

    public void save(Party party) {
        partyDao.save(party);
    }

    public void del(Integer id) {
        partyDao.delete(id);
    }

    public int getTotalCount() {
        return partyDao.getTotalCount();
    }

    public Party getLeftSiblingById(Integer id) {
        return partyDao.getLeftSiblingByid(id);
    }
    public Party getRightSiblingById(Integer id) {
        return partyDao.getRightSiblingByid(id);
    }
}
