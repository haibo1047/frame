<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>-</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
  </head>
  
  <body>
	<a href="add.do">新增</a>
    <ec:table items="objectList" var="drug" imagePath="${ctx}/images/table/*.gif" action="list.do" filterable="false">
    	<ec:row>
    		<ec:column property="id"></ec:column>
    		<ec:column property="drugName" alias="药品名称"></ec:column>
    		<ec:column property="simpleSpell" alias="简拼"></ec:column>
    		<ec:column alias="操作" sortable="false">
				<a href="edit.do?id=${drug.id}">修改</a>
				<a href="delete.do?id=${drug.id}">删除</a>
    		</ec:column>
    	</ec:row>
    </ec:table>
  </body>
</html>
