package com.concur.service;

import com.concur.dao.ArchiveRunDao;
import com.concur.dao.HostDaoImpl;
import com.concur.model.ArchiveRun;
import com.concur.model.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EntityServiceImpl implements EntityService {

    @Autowired
    private HostDaoImpl hostDao;

    public EntityServiceImpl() {}

    @Override
    public EntityInfo getEntityInfo(String entityCode) throws DataAccessException {
        return hostDao.getEntityKey(entityCode);
    }

}
