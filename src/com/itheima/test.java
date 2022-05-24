package com.itheima;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Route;
import com.itheima.service.RouteService;
import com.itheima.service.RouteServiceImpl;
import org.testng.annotations.Test;

import java.util.List;

public class test {
    private RouteService routeService = new RouteServiceImpl();

    @Test
    public void test(){
        List<Route> all = routeService.findAll();
        System.out.println(all);

    }
    @Test
    public void test1(){
        Route route=new Route();
        route.setRid(1);
        route.setRname("黄山");
        route.setRouteIntroduce("sadasd");
        routeService.add(route);
    }
    @Test
    public void test2(){
        Route route = routeService.updateFindById("1");
        System.out.println(route);
    }
    @Test
    public void test3(){
        PageInfo findpage = routeService.findpage(1, 5);
        System.out.println(findpage);
    }
}
