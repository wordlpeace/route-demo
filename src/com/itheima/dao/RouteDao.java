package com.itheima.dao;


import com.itheima.domain.Route;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RouteDao {
    @Select("select * from  route_demo.tab_route")
    //查询
    List<Route> findAll();
    //添加旅游线路
    @Insert("insert into route_demo.tab_route(rname,price,routeIntroduce) values(#{rname},#{price},#{routeIntroduce})")
    void add(Route route);
    //删除旅游线路
    @Delete("delete from route_demo.tab_route where tab_route.rid=#{rid}")
    void del(String rid);
    //修改旅游线路--回显
    @Select("select * from route_demo.tab_route where rid=#{rid}")
    Route updateFindById(String rid);
    //修改旅游线路
    @Update("update route_demo.tab_route set rname=#{rname},price=#{price},routeIntroduce=#{routeIntroduce} where rid=#{rid}")
    void update(Route route);
}
