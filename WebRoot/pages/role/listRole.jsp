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
	<a href="add.do">新增</a>
    <ec:table items="objectList" var="role" action="list.do" imagePath="${ctx}/images/table/*.gif" filterable="false">
    	<ec:row>
    		<ec:column property="id"></ec:column>
    		<ec:column property="roleName" alias="角色名称"></ec:column>
    		<ec:column property="roleDesc" alias="角色描述"></ec:column>
    		<ec:column property="authority" alias="权限"></ec:column>
    		<ec:column  alias="操作" sortable="false">
				<a href="configUser.do?id=${role.id}">配置用户</a>
				<a href="configMenu.do?id=${role.id}">配置菜单</a>
				<a href="edit.do?id=${role.id}">编辑</a>
				<a href="delete.do?id=${role.id}">删除</a>
    		</ec:column>
    	</ec:row>
    </ec:table>
  </body>
</html>
