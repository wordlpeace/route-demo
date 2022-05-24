package com.itheima.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.RouteDao;
import com.itheima.domain.Route;
import com.itheima.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    //查询
    public List<Route> findAll() {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        List<Route> all = mapper.findAll();
        MybatisUtil.close(sqlSession);
        return all;
    }

    //删除
    public void del(String rid) {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        mapper.del(rid);
        MybatisUtil.commit(sqlSession);
        MybatisUtil.close(sqlSession);

    }

    //添加
    public void add(Route route) {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        mapper.add(route);
        MybatisUtil.commit(sqlSession);
      MybatisUtil.close(sqlSession);

    }

    // 根据id获取旅游线路
    public Route updateFindById(String rid) {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        Route route = mapper.updateFindById(rid);
        MybatisUtil.close(sqlSession);
        return route;
    }

    //修改
    public void update(Route route) {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        mapper.update(route);
        MybatisUtil.commit(sqlSession);
        MybatisUtil.close(sqlSession);


    }

    @Override
    public PageInfo findpage(int pageNum, Integer pageSize) {
        SqlSession sqlSession = MybatisUtil.openSession();
        RouteDao mapper = sqlSession.getMapper(RouteDao.class);
        PageHelper.startPage(pageNum, pageSize);
        List<Route> all = mapper.findAll();
        MybatisUtil.commit(sqlSession);
        MybatisUtil.close(sqlSession);
        return new PageInfo(all);

    }

}
