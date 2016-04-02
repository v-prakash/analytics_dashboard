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

import com.concur.controller.DatasourceConfig;
import com.concur.controller.DwDatasourceConfig;
import com.concur.model.ArchiveRun;
import com.concur.model.EntityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
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
public class HostDaoImpl {

    @Autowired
    @Qualifier("jdbcHost")
    private JdbcTemplate jdbcTemplate;

    @Autowired
    DatasourceConfig datasourceConfig;

    public HostDaoImpl() {
        System.out.println("in host dao impl constructor:" + datasourceConfig);
    }

    public EntityInfo getEntityKey(String entity) {
        if (entity == null || entity.equals(""))
          return null;
        System.out.println("get entity key for:" + entity);
//        System.out.println("hostdb="+jdbcTemplate.getDataSource().toString());
/*
        String sql = "SELECT entity_key from dbo.cth_entity where entity_code = ?";
        Integer entityKey = jdbcTemplate.queryForObject(sql, new Object[] { entity}, Integer.class);
        return (entityKey != null?entityKey.intValue():-1);
*/
        String sql = "select e.entity_key, e.entity_code, server_name, " +
                            "schema_name, user_name username, user_passw password " +
                     "from cth_entity e " +
                     "join CTH_DB_CONN_MAP dcm on dcm.entity_key = e.ENTITY_KEY " +
                     "join CTH_APPLICATION a on a.APP_KEY = dcm.APP_KEY " +
                     "where e.ENTITY_CODE = ? " +
                     "and a.NAME = 'Reporting'";
        return (EntityInfo)jdbcTemplate.queryForObject(sql, new Object[]{entity},
                                            BeanPropertyRowMapper.newInstance(EntityInfo.class));
    }
}
