package com.geek.spring.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Description
 * @ClassName DataSourceBean
 * @Author Liumh
 * @Date 2019/2/16 11:08
 * @Version v1.0
 */
@Slf4j
@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "origin.spring.datasource")
    public DataSourceProperties originDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "cut.spring.datasource")
    public DataSourceProperties cutDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    public DataSource originDataSource(){
        DataSourceProperties origin = originDataSourceProperties();
        log.info("origin JDBC URL:{}", origin.getUrl());
        return origin.initializeDataSourceBuilder().build();
    }

    @Bean
    public DataSource cutDataSource(){
        DataSourceProperties cut = cutDataSourceProperties();
        log.info("cut JDBC URL:{}", cut.getUrl());
        return cut.initializeDataSourceBuilder().build();
    }

    @Bean
    @Resource
    public PlatformTransactionManager originTxManager(DataSource originDataSource) {
        try {
            Connection connection = originDataSource.getConnection();
            log.info("origin Connection:{}", connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DataSourceTransactionManager(originDataSource);
    }

    @Bean
    @Resource
    public PlatformTransactionManager cutTxManager(DataSource cutDataSource) {
        try {
            Connection connection = cutDataSource.getConnection();
            log.info("cut Connection:{}", connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new DataSourceTransactionManager(cutDataSource);
    }
}
