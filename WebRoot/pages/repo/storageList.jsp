<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>bill</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<a href="addBill.do">新增</a>
  	<ec:table items="billList" var="bill" imagePath="${ctx}/images/table/*.gif" action="storage.do" filterable="false">
  		<ec:row>
			<ec:column property="id" alias="ID"/>
			<ec:column property="billNo" alias="单号"/>
			<ec:column property="createDate" alias="创建时间"/>
			<ec:column property="createUser" alias="创建人"/>
			<ec:column property="available.label" alias="是否生效"/>
			<ec:column alias="操作" sortable="false">
				<a href="editBill.do?id=${bill.id}">编辑</a>
				<a href="delete.do?id=${bill.id}">删除</a>
			</ec:column>
		</ec:row>
  	</ec:table>
  </body>
</html>
