<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>configUser</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
  </head>
  
  <body>
  	<form:form modelAttribute="user" action="saveConfigUser.do" method="post">
	<table >
		<tr>
			<td>
				未选用户
			</td>
			<td>
				已选用户
			</td>
		</tr>
		<tr>
			<td>
				<form:select path="userList" items="userList" itemLabel="realName" itemValue="id"></form:select>
			</td>
		</tr>
	</table>
  	</form:form>
  </body>
</html>
