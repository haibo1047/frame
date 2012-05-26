<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>add</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
  </head>
  
  <body>
	<a href="add.do">新增</a>
    <ec:table items="objectList" var="provider" action="list.do" imagePath="${ctx}/images/table/*.gif" filterable="false">
    	<ec:row>
    		<ec:column property="id"></ec:column>
    		<ec:column property="providerName" alias="供应商名称"></ec:column>
    		<ec:column property="commonContact" alias="联系人"></ec:column>
    		<ec:column property="providerTel" alias="电话"></ec:column>
    		<ec:column  alias="操作" sortable="false">
				<a href="edit.do?id=${provider.id}">编辑</a>
				<a href="delete.do?id=${provider.id}">删除</a>
    		</ec:column>
    	</ec:row>
    </ec:table>
  </body>
</html>
