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
  <script type="text/javascript">
  	function goback(){
  		location = "${ctx}/provider/list.do";
  	}
  	</script>
  </head>
  
  <body>
  	<form:form action="save.do" method="post" modelAttribute="object" name="f1">
  		增加用户
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
		<table class="mainTable">
			<tr>
				<td>供应商名称:</td>
				<td>
					<form:input path="providerName"/>
				</td>
			</tr>
			<tr>
				<td>联系人:</td>
				<td>
					<form:input path="commonContact"/>
				</td>
			</tr>
			<tr>
				<td>电话:</td>
				<td>
					<form:input path="providerTel"/>
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
