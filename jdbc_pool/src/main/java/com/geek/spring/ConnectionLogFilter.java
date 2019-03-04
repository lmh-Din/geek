package com.geek.spring;

import com.alibaba.druid.filter.FilterChain;
import com.alibaba.druid.filter.FilterEventAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.Properties;

/**
 * @Description
 * @ClassName ConnectionLogFilter
 * @Author Liumh
 * @Date 2019/2/16 15:13
 * @Version v1.0
 */
@Slf4j
public class ConnectionLogFilter extends FilterEventAdapter {

    @Override
    public void connection_connectBefore(FilterChain chain, Properties info) {
        log.info("Connection Before...");
    }
}
