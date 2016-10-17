<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'show.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<table align="center" width="60%" border="1">
		<tr align="right">
			<td colspan="6">当前用户${u.username } <a href="pages/add.jsp">发帖</a>&nbsp;&nbsp;&nbsp;<a
				href="#">退出</a>
				<input type="hidden" name="usname" value="${name1 }">
				
			</td>
			
		</tr>
		<tr align="center">
			<th>编号</th>
			<th>标题</th>
			<th>贴主</th>
			<th>发帖时间</th>
			<th>回复数</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${showlist }" var="l">
			<tr align="center">
				
				<td>${l.id }</td>
				<td>${l.tTitle }</td>
				<td>${l.userName }</td>
				<td><fmt:formatDate value="${l.tTime }" pattern="yyyy-MM-dd"/></td>
				<td>${l.c }</td>
				<td>
				<c:if test="${u.username!='admin'||u.username=='admin'}">
				<a href="Show?method=findByShow&id=${l.id }">查看</a>
				</c:if>
				<c:if test="${u.username=='admin'}">
				<a href="Show?method=deleteInfo&id=${l.id }">删除</a>
				</c:if>
			
		
				
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="6">
				<c:if test="${p.index==1 }">
				首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
				</c:if>
				<c:if test="${p.index!=1 }">
				<a href="Show?method=change&index=1">首页</a>&nbsp;&nbsp;<a href="Show?method=change&index=${p.index-1 }">上一页</a>&nbsp;&nbsp;
				</c:if>
				<c:if test="${p.index==p.maxPage }">
				下一页&nbsp;&nbsp;尾页&nbsp;&nbsp;
				</c:if>
				<c:if test="${p.index!=p.maxPage }">
				<a href="Show?method=change&index=${p.index+1 }">下一页</a>&nbsp;&nbsp;<a href="Show?method=change&index=${p.maxPage }">尾页</a>&nbsp;&nbsp;
				</c:if>
					共<span>${p.count }</span>条&nbsp;
    				每页<span>${p.size }</span>条&nbsp;
    				共<span>${p.maxPage }</span>页&nbsp;
			</td>
		</tr>

	</table>
</body>
</html>
