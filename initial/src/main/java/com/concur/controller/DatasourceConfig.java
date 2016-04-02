package com.concur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@EnableConfigurationProperties({DatasourceConfig.HostDBProperties.class})
public class DatasourceConfig  {

    @Autowired
    HostDBProperties hostDBProperties;

    @ConfigurationProperties(prefix = "spring.host")
    static class HostDBProperties extends DataSourceProperties {}

    @Bean(name="dsHost")
    @Primary
    public DataSource dataSourceHost() {
        return createDataSource(hostDBProperties);
    }

    @Bean(name="jdbcHost")
    public JdbcTemplate jdbcTemplate(DataSource hostDs) {
        return new JdbcTemplate(hostDs);
    }

    private DataSource createDataSource(DataSourceProperties properties){
        System.out.println(properties);
        DataSourceBuilder factory = DataSourceBuilder
                                    .create(properties.getClassLoader())
                                    .driverClassName(properties.getDriverClassName())
                                    .url(properties.getUrl())
                                    .username(properties.getUsername())
                                    .password(properties.getPassword());
        return factory.build();
    }
}
