<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册成功</title>

</head>
<body>
<!--引入头部-->
<jsp:include page="header.jsp"></jsp:include>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改旅游线路信息</h3>
    <form action="${pageContext.request.contextPath}/findAllServlet?method=comitupdate" method="post">

        <%--隐藏域用于携带id属性--%>
        <input type="hidden" name="rid" value="${route.rid}">

        <div class="form-group">
            <label for="rname">线路名：</label>
            <input type="text" class="form-control" id="rname"  name="rname" value="${route.rname}"  placeholder="请输入线路名" />
        </div>


        <div class="form-group">
            <label for="price">线路价格：</label>
            <input type="text" class="form-control" id="price" name="price"  value="${route.price}"   placeholder="请输入线路价格" />
        </div>


        <div class="form-group">
            <label for="price">线路描述：</label>
            <input type="text" class="form-control" id="routeIntroduce" name="routeIntroduce" value="${route.routeIntroduce}" placeholder="请输入线路描述"/>
        </div>



        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>