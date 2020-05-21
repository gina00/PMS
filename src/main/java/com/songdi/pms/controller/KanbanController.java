package com.songdi.pms.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.songdi.pms.datasource.dynamic.DynamicDataSourceContextHolder;
import com.songdi.pms.vo.TaskVo;
import com.songdi.pms.zt.dao.ZtProductRepository;
import com.songdi.pms.zt.domain.ZtProduct;

import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kanban")
public class KanbanController {
    @Autowired
    private ZtProductRepository ztProductRepository;
    @Autowired
    private org.redisson.api.RedissonClient redisson;

    @PostMapping("")
    public ZtProduct save(@RequestBody TaskVo taskVo) {
        RMap<String, TaskVo> map = redisson.getMap("kanban");
        map.put(taskVo.getName(),taskVo);
        return ztProductRepository.findById(12L).get();
    }
    @GetMapping("/list")
    public List<TaskVo> list() {
        RMap<String, TaskVo> map= redisson.getMap("kanban");
        return map.values().stream().collect(Collectors.toList());
    }
    @PostMapping("/delete")
    public void list(@RequestBody TaskVo taskVo) {
        RMap<String, TaskVo> map= redisson.getMap("kanban");
        map.remove(taskVo.getName());
    }
}
