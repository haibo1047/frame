<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'listUser.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
	<a href="addRepository.do">新增</a>
  	<ec:table items="objectList" var="repo" imagePath="${ctx}/images/table/*.gif" action="list.do" filterable="false">
  		<ec:row>
			<ec:column property="id" alias="ID"/>
			<ec:column property="repositoryName" alias="仓库名称"/>
			<ec:column property="repoAddress" alias="仓库地址"/>
			<ec:column alias="操作" sortable="false">
				<a href="edit.do?id=${repo.id}">view</a>
				<a href="delete.do?id=${repo.id}">删除</a>
			</ec:column>
		</ec:row>
  	</ec:table>
  </body>
</html>
