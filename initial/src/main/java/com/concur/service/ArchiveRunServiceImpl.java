package com.concur.service;

import com.concur.dao.ArchiveRunDao;
import com.concur.model.ArchiveRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ArchiveRunServiceImpl implements ArchiveRunService {

    @Autowired
    private ArchiveRunDao archiveRunDao;

    public ArchiveRunServiceImpl() {}

    @Override
    public Collection<ArchiveRun> findArchiveRuns() throws DataAccessException {
        System.out.println("in archive run com.concur.service impl");
        return archiveRunDao.findArchiveRuns();
    }

}
