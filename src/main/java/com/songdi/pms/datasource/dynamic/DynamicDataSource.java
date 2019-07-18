package com.songdi.pms.datasource.dynamic;

import java.util.Map;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    public Map<Object, Object> myMap = null;

    @Override
    protected Object determineCurrentLookupKey() {
        /*
        
         * DynamicDataSourceContextHolder代码中使用setDataSourceType
        
         * 设置当前的数据源，在路由类中使用getDataSourceType进行获取，
        
         *  交给AbstractRoutingDataSource进行注入使用。
        
         */

        return DynamicDataSourceContextHolder.getDataSourceType();

    }

}
