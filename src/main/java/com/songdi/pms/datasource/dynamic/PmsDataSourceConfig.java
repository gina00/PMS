package com.songdi.pms.datasource.dynamic;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PmsDataSourceConfig {
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource(@Qualifier("primaryDataSource") DataSource dataSource,
        @Qualifier("ztDataSource") DataSource ztDataSource, @Qualifier("sonarDataSource") DataSource sonarDataSource) {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.myMap = new HashMap<>();// 保存我们有的数据源，方便后面动态增加
        dynamicDataSource.myMap.put("pms", dataSource);
        dynamicDataSource.myMap.put("zt", ztDataSource);
        dynamicDataSource.myMap.put("sonar", sonarDataSource);
        dynamicDataSource.setTargetDataSources(dynamicDataSource.myMap);// 父类的方法
        dynamicDataSource.setDefaultTargetDataSource(dataSource);// 父类的方法
        return dynamicDataSource;
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSourceProperties firstDataSourceProperties() {
        DataSourceProperties ss = new DataSourceProperties();
        return ss;
    }

    @Bean(name = "primaryDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.primary")
    public DataSource firstDataSource() {
        return firstDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.zt")
    public DataSourceProperties ztDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "ztDataSource")
    @ConfigurationProperties("spring.datasource.zt")
    public DataSource ztDataSource() {
        return ztDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.sonar")
    public DataSourceProperties sonarDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "sonarDataSource")
    @ConfigurationProperties("spring.datasource.sonar")
    public DataSource sonarDataSource() {
        return sonarDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
