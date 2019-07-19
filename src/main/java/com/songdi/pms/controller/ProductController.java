package com.songdi.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.songdi.pms.datasource.dynamic.DynamicDataSourceContextHolder;
import com.songdi.pms.zt.dao.ZtProductRepository;
import com.songdi.pms.zt.domain.ZtProduct;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ZtProductRepository ztProductRepository;

    @GetMapping("/{db}/{id}")
    public ZtProduct getProduct(@PathVariable String db,@PathVariable Long id) {
        DynamicDataSourceContextHolder.setDataSourceType(db);
        return ztProductRepository.findById(id).get();
    }
}
