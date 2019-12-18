<%--
  Created by IntelliJ IDEA.
  User: pc
  Date: 2019/9/22
  Time: 12:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<jsp:include page="left.jsp"></jsp:include>

<div id="content" style="margin-right: 100px;margin-top: 40px;">
    <!--breadcrumbs-->
    <div id="content-header">
        <div id="breadcrumb">
            <a title="主页" class="tip-bottom" href="<%=basePath%>admin/indexs"><i class="icon-home"></i>主页</a>
        </div>
    </div>
    <!--End-breadcrumbs-->

    <!-- 主要内容 -->
    <div class="container-fluid">
        <div class="quick-actions_homepage">
            <ul class="quick-actions">
                <li class="bg_lb"><a
                        href="<%=basePath%>admin/userList?pageNum=1"> <i
                        class="icon-group"></i>用户管理
                </a></li>
                <li class="bg_lg span3"><a
                        href="<%=basePath%>admin/goodsList?pageNum=1"> <i
                        class="icon-signal"></i>商品管理
                </a></li>
                <li class="bg_lo"><a
                        href="<%=basePath%>admin/ordersList?pageNum=1"> <i
                        class="icon-th"></i>订单管理
                </a></li>
                <li class="bg_ly"><a href="<%=basePath%>admin/purseList?pageNum=1">
                    <i class="icon-inbox"></i>钱包管理
                </a></li>
                <li class="bg_ls"><a href=""> <i class="icon-fullscreen"></i>系统设置
                </a></li>
            </ul>
        </div>
    </div>
</div>



</body>
</html>
