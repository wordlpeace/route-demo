package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Route;

import java.util.List;

public interface RouteService {
    //查询
    List<Route> findAll();

    //删除
    void del(String rid);

    //添加
    void add(Route route);

    // 根据id获取旅游线路数据回显
    Route updateFindById(String rid);

    //修改
    void update(Route route);

  PageInfo findpage(int pageNum, Integer pageSize);

}
