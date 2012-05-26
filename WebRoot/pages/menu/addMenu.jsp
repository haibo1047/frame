<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

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
  		location = "${ctx}/menu/listMenu.do";
  	}
  	</script>
  </head>
  
  <body>
  	<form:form action="saveMenu.do" modelAttribute="menu" name="f1" method="post">
  		增加用户
  		<div class="clum_title"></div>
		<table border="0" cellpadding="0" cellspacing="0" class="mainTable">
  			<form:hidden path="id"/>
			<tr>
				<td class="fm_left">路径：</td>
				<td>
					<form:input path="menuPath"/>
				</td>
			</tr>
			<tr>
				<td class="fm_left">地址：</td>
				<td>
					<form:input path="menuUrl"/>
				</td>
			</tr>
			<tr>
				<td class="fm_left">排序号：</td>
				<td>
					<form:input path="menuOrder"/>
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
