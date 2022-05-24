<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>线路列表</title>
    <link rel="stylesheet" href="css/search.css">
</head>
<body>
<!--引入头部-->

<jsp:include page="header.jsp"></jsp:include>
<div class="page_one">
    <div class="contant">
        <div class="crumbs">
            <img src="images/search.png" alt="">
            <p>黑马旅行><span>搜索结果</span></p>
        </div>
        <div class="xinxi clearfix">
            <%--线路列表 start--%>
            <div class="left">
                <div class="header">
                    <span>商品信息</span>
                    <span class="jg"><a href="${pageContext.request.contextPath}/add.jsp">新增旅游线路</a></span>
                </div>
                <ul>

                    <c:if test="${not empty list}" >
                        <c:forEach items="${list}" var="route">
                            <li>
                                <div class="img"><img src="${route.rimage}" width="300px" alt="本功能不支持图片上传..无需实现"></div>
                                <div class="text1">
                                    <p>${route.rname}</p>
                                    <br/>
                                    <p>${route.routeIntroduce}</p>
                                </div>
                                <div class="price">
                                    <p class="price_num">
                                        <span>&yen;</span>
                                        <span>${route.price}</span>
                                        <span>起</span>
                                    </p>
                                    <p><a href="javascript:void(0);" onclick="deleteById(${route.rid})">删除</a></p>
                                    <p><a href="${pageContext.request.contextPath}/findAllServlet?method=updateFindById&rid=${route.rid}">修改</a></p>
                                </div>
                            </li>
                        </c:forEach>
                    </c:if>

                    <script>
                        //弹出框  提示一下是否删除
                        function  deleteById(rid){
                            let flag = window.confirm("您是否确定删除这条数据?");
                            if(flag){
                                location.href="${pageContext.request.contextPath}/findAllServlet?method=DeleteServlet&rid="+rid;
                            }
                        }
                        function toPage(num){
                            location.href="${pageContext.request.contextPath}/findAllServlet?method=findall&num="+num;
                        }
                    </script>
                   
                </ul>
                <div class="page_num_inf">
                    <i></i> 共
                    <span>12</span>页<span>132</span>条
                </div>
                <div class="pageNum">
                    <ul>
                        <li><a href="javascript:toPage(1)">首页</a></li>
                        <li class="threeword"><a href="javascript:toPage(${pageInfo.prePage})">上一页</a></li>
                        <c:forEach items="${pageInfo.navigatepageNums}" var="num">
                            <li><a href="javascript:toPage(${num})">${num}</a></li>
                        </c:forEach>
                        <li class="threeword"><a href="javascript:toPage(${pageInfo.nextPage})">下一页</a></li>
                        <li class="threeword"><a href="javascript:toPage(${pageInfo.pages})">末页</a></li>
                        <span>总${pageInfo.total}条记录,共${pageInfo.pages}页</span>
                    </ul>

                </div>
            </div>
            <%--线路列表--%>
            <%--热门推荐 start--%>
            <div class="right">

                <div class="top">
                    <div class="hot">HOT</div>
                    <span>热门推荐</span>
                </div>
                <ul>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                    <li>
                        <div class="left"><img src="images/04-search_09.jpg" alt=""></div>
                        <div class="right">
                            <p>清远新银盏温泉度假村酒店/自由行套...</p>
                            <p>网付价<span>&yen;<span>899</span>起</span>
                            </p>
                        </div>
                    </li>
                </ul>
            </div>
            <%--热门推荐 end--%>
        </div>
    </div>
</div>

<!--引入头部-->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
