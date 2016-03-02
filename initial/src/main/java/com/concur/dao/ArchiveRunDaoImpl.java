/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.concur.dao;

import com.concur.model.ArchiveRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author Ken Krebs
 * @author Juergen Hoeller
 * @author Rob Harrop
 * @author Sam Brannen
 * @author Thomas Risberg
 * @author Mark Fisher
 */
@Repository
public class ArchiveRunDaoImpl implements ArchiveRunDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArchiveRunDaoImpl() {

    }

    @Override
    public Collection<ArchiveRun> findArchiveRuns() throws DataAccessException {
        System.out.println("in archive run com.concur.dao impl");
        return this.jdbcTemplate.query(
                "SELECT  etl_batch_key job_key, etl_status job_status, " +
                "DATEDIFF(MINUTE, etl_start_dttm, etl_end_dttm) job_duration " +
                "FROM dbo.dim_etl_batch " +
                "WHERE job_type = 'DW_GEXP_ARCHIVE' " +
                "AND etl_status NOT IN ('RUNNING') " +
                "ORDER BY etl_batch_key",
                BeanPropertyRowMapper.newInstance(ArchiveRun.class));
    }
}
