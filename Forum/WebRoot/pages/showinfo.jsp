<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showinfo.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
th {
	background-color: yellow;
}

tr {
	background-color: gray;
}
</style>

<script type="text/javascript">
function showComment(obj){
	
	
	var div = document.getElementById(obj);
	var button = document.getElementById("commentButton");
	div.style.display=div.style.display=="none"?"block":"none";
	button.value=button.value=="我要评论"?"关闭评论":"我要评论";
	document.getElementById("rcontents").value="";

}

</script>
</head>

<body>
	<table align="center" border="1" width="60%" cellpadding="10"
		cellspacing="0">

		<tr align="right">
			<td colspan="6">当前用户${u.username }<a href="javascript:void(0)" onclick="history.go(-1)">返回上一级</a><a
				href="#">退出</a>

			</td>
		</tr>
		<c:forEach items="${findlist }" var="l">
			<tr align="center">

				<th>主题:</th>
				<th>${l.tTitle }</th>
				<th>贴主:</th>
				<th>${l.username }</th>
				<th>发帖时间</th>
				<th><fmt:formatDate value="${l.tTime }" pattern="yyyy-MM-dd" />
				</th>

			</tr>

			<tr>
				<td colspan="6">${l.tcontent }</td>
			</tr>
		</c:forEach>
		<c:forEach items="${showinfolist }" var="l" varStatus="index">
			<tr>
				<td>${index.count }楼</td>
				<td>主题:${l.tTitle }</td>
				<td colspan="2">回帖时间:<fmt:formatDate value="${l.rTime }"
						pattern="yyyy-MM-dd" />
						
						</td>
				<td colspan="2">回帖人:${l.username }</td>
			</tr>
			<tr>
				<td colspan="6">${l.rcontent }
				
				</td>
			</tr>
		</c:forEach>
		<tr align="center">
			<td colspan="6"><c:if test="${showinfop.index==1 }">
				首页&nbsp;&nbsp;上一页&nbsp;&nbsp;
				</c:if> <c:if test="${showinfop.index!=1 }">
					<a href="Show?method=ShowInfochange&index=1">首页</a>&nbsp;&nbsp;<a
						href="Show?method=ShowInfochange&index=${showinfop.index-1 }">上一页</a>&nbsp;&nbsp;
				</c:if> <c:if
					test="${showinfop.index==showinfop.maxPage||showinfop.count==0 }">
				下一页&nbsp;&nbsp;尾页&nbsp;&nbsp;
				</c:if> <c:if
					test="${showinfop.index!=showinfop.maxPage&&showinfop.count!=0 }">
					<a
						href="Show?method=ShowInfochange&index=${showinfop.index+1 }">下一页</a>&nbsp;&nbsp;<a
						href="Show?method=ShowInfochange&index=${showinfop.maxPage }">尾页</a>&nbsp;&nbsp;
				
				</c:if> 共<span>${showinfop.count }</span>条&nbsp; 每页<span>${showinfop.size }</span>条&nbsp;
				共<span>${showinfop.maxPage }</span>页&nbsp;</td>
		</tr>
	
		<tr align="right">
			<td colspan="6">已有${showinfop.count }位网友对此发表评论<input id="commentButton" type="button" value="我要评论" style="border-style: solid" onclick="showComment('commentDiv')"/></td>
		</tr>
		
	</table>
	<div id="commentDiv" style="display:none;">
    	<form action="Show?method=AddLiuyan" method="post">
	    	<table width="30%" border="0">
	    		<Tr>
	    			<Td colspan="6"><b>请您留言</b></Td>
	    		</Tr>
	    		<tr>
	    			<td colspan="6">
	    				<textarea rows="10" cols="30" name="liuyan">
	    				
	    				
	    				</textarea><!-- 留言 -->
	    			</td>    		
	    		</tr>
		   		<tr>
	    			<td colspan="6">
	    			<input type="hidden" name="hddid" value="${u.id }">
	    				
	    			</td>    		
	    		</tr>	    		
	    		<Tr>
	    			<Td colspan="6">
	    				<input type="submit" value="提交留言"/>
	    			</Td>
	    		</Tr>
	    	</table>
    	<form>
    </div>
	
</body>
</html>
