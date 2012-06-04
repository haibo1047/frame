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
	<script type="text/javascript" src="<c:url value="/js/select.js"/>"></script>
	<script>
	init("unselectUsers","selectedUsers");
	</script>
  </head>
  
  <body>
  	<form:form modelAttribute="object" action="saveConfigUser.do" method="post" name="f1">
  		<form:hidden path="id"/>
  		配置用户
  		<div class="clum_title"></div>
		<table class="mainTable">
			<tr>
				<td>
					未选用户
				</td>
				<td></td>
				<td>
					已选用户
				</td>
			</tr>
			<tr>
				<td>
					<form:select path="unselectIds" id="unselectUsers"
						items="${unselectUsers}" itemLabel="username" itemValue="id"
						ondblclick="moveIt(this,selectedUsers,1)" cssStyle="width:150px;"></form:select>
				</td>
				<td>
					<input type="button" value="--->" onclick="onClick='javascript:moveIt(unselectUsers,selectedUsers,1)'">
					<br>
					<input type="button" value="&lt;---" onclick="onClick='javascript:moveIt(unselectUsers,selectedUsers,2)'">
				</td>
				<td>
					<form:select id="selectedUsers" path="selectedIds" multiple="true"
						items="${selectedUsers}" itemLabel="username" itemValue="id"
						ondblclick="moveIt(this,unselectUsers,2)" cssStyle="width:150px;">
					</form:select>
				</td>
			</tr>
			
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
