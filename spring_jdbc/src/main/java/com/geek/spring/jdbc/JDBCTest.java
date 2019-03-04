package com.geek.spring.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description
 * @ClassName JDBCTest
 * @Author Liumh
 * @Date 2019/2/16 9:53
 * @Version v1.0
 */
@RestController
@RequestMapping("/jdbc")
@Slf4j
public class JDBCTest {

    @Autowired
    private DataSource dataSource;


}
