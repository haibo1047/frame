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
	<a href="importDrug.do">导入</a>
	<a href="exportDrug.do" target="_blank">导出</a>
    <ec:table items="objectList" var="drug" imagePath="${ctx}/images/table/*.gif" action="list.do" filterable="false">
    	<ec:row>
    		<ec:column property="id"></ec:column>
    		<ec:column property="drugName" alias="药品名称"></ec:column>
    		<ec:column property="simpleSpell" alias="简拼"></ec:column>
    		<ec:column property="drugType" alias="类型"></ec:column>
    		<ec:column property="drugProvider.providerName" alias="供应商"></ec:column>
    		<ec:column property="drugUnit" alias="单位"></ec:column>
    		<ec:column property="guaranteeMonth" alias="保持期(月)"></ec:column>
    		<ec:column property="approvalNumber" alias="批准文号"></ec:column>
    		<ec:column property="productModel" alias="规格"></ec:column>
    		<ec:column property="manufacturer" alias="生产厂商"></ec:column>
    		<ec:column property="drugForm" alias="剂型"></ec:column>
    		<ec:column alias="操作" sortable="false">
				<a href="edit.do?id=${drug.id}">修改</a>
				<a href="delete.do?id=${drug.id}">删除</a>
    		</ec:column>
    	</ec:row>
    </ec:table>
  </body>
</html>
