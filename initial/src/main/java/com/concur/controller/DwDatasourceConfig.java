package com.concur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by PrakashV on 3/9/2016.
 */
@Configuration
@EnableConfigurationProperties({DwDatasourceConfig.DwDBProperties.class})
public class DwDatasourceConfig {

    @Autowired
    DwDBProperties dwDBProperties;

    @ConfigurationProperties(prefix = "spring.datasource")
    static class DwDBProperties extends DataSourceProperties {}

    @Bean(name="dsDW")
    public DataSource dataSourceDw() {
        return createDataSource(dwDBProperties);
    }

    @Bean(name="jdbcDW")
    public JdbcTemplate jdbcTemplate(DataSource dwDs) {
        return new JdbcTemplate(dwDs);
    }

    private DataSource createDataSource(DataSourceProperties properties){
        DataSourceBuilder factory = DataSourceBuilder
                                    .create(properties.getClassLoader())
                                    .driverClassName(properties.getDriverClassName())
                                    .url(properties.getUrl())
                                    .username(properties.getUsername())
                                    .password(properties.getPassword());
        return factory.build();
    }
}
