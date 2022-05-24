package com.itheima.web;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Route;
import com.itheima.service.RouteService;
import com.itheima.service.RouteServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet(urlPatterns = "/findAllServlet")
public class findAllServlet extends HttpServlet {


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        RouteService service = new RouteServiceImpl();
//        List<Route> list = service.findAll();
//        request.setAttribute("list",list);
//        request.getRequestDispatcher("/route_list.jsp").forward(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request,response);
//    }
//}
//public class findAllServlet extends HttpServlet {
    private RouteService routeService=new RouteServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if("findall".equals(method)){
            findall(req,resp);

        }
        if ("AddServlet".equals(method)){
            try {
                AddServlet(req,resp);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        if ("updateFindById".equals(method)){
            updateFindById(req,resp);
        }
        if ("comitupdate".equals(method)){
            comitupdate(req,resp);
        }
        if ("DeleteServlet".equals(method)){
            DeleteServlet(req,resp);
        }

        }

    private void DeleteServlet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String rid = req.getParameter("rid");
        routeService.del(rid);
        resp.sendRedirect(req.getContextPath()+"/findAllServlet?method=findall");

    }

    private void comitupdate(HttpServletRequest req, HttpServletResponse resp) {
        Route route = new Route();
        try {
            BeanUtils.populate(route,req.getParameterMap());
            routeService.update(route);
//            resp.sendRedirect(req.getContextPath()+"/findAllServlet?method=findall");
            resp.sendRedirect(req.getContextPath()+"/findAllServlet?method=findall");
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void updateFindById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rid = req.getParameter("rid");
        Route route = routeService.updateFindById(rid);
        req.setAttribute("route",route);
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    private void AddServlet(HttpServletRequest req, HttpServletResponse resp) throws InvocationTargetException, IllegalAccessException, IOException {
        Route route = new Route();
        BeanUtils.populate(route,req.getParameterMap());
        routeService.add(route);
       resp.sendRedirect(req.getContextPath()+"/findAllServlet?method=findall");
    }

    private void findall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String num = req.getParameter("num");
//        String size = req.getParameter("size");
        int i = Integer.parseInt(num);
//        int i1 = Integer.parseInt(size);
        PageInfo findpage = routeService.findpage(i, 5);
        List list = findpage.getList();;
        req.setAttribute("list",list);
        req.setAttribute("pageInfo",findpage);
                req.getRequestDispatcher("/route_list.jsp").forward(req,resp);
    }
}
