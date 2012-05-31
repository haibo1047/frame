<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
  </head>
  
  <body>
  	<form:form action="save.do" method="post" modelAttribute="object" name="f1">
  		增加角色
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
		<table class="mainTable">
			<tr>
				<td>角色名称:</td>
				<td>
					<form:input path="roleName"/>
				</td>
			</tr>
			<tr>
				<td>角色描述:</td>
				<td>
					<form:input path="roleDesc"/>
				</td>
			</tr>
			<tr>
				<td>权限:</td>
				<td>
					<form:input path="authority"/>
				</td>
			</tr>
			<tr class="g_line"> <td colspan="2"></td></tr>
			<tr>
				<td class="fm_left"></td>
				<td>
					<span class="f_btn">
						<input type="button" value="确认" onclick="f1.submit()" class="r_btn"/>
					</span>
					<span class="f_btn">
						<input type="button" value="返回" onclick="goback()" class="r_btn"/>
					</span>
				</td>
			</tr>
		</table>
  	</form:form>
  	
  </body>
</html>
