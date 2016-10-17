<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  		<form action="User?method=Login" method="post">
    	<table align="center" width="60%" border="0">
    		<tr align="center">
    			<td>
    				用户名:<input type="text" name="username">
    				
    			</td>
    		
    		</tr>
    		<tr align="center">
    			<td>
    				密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password">
    			</td>
    		</tr>
    		<tr align="center">
    			<td>
    				<input type="submit" value="登录">&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="注册" onclick="window.location.href='adduser.jsp'">${err }
    			</td>
    			
    			
    				
    			
    		</tr>
    	
    	</table>
    	</form>
  </body>
</html>
