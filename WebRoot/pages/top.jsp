<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<title>_</title>
		<script language=JavaScript>
	function logout() {
		if (confirm("您确定要退出系统吗？"))
			top.location = "<c:url value='/security_logout.do'/>";
		return false;
	}
</script>
		<meta http-equiv=Content-Type content=text/html;charset=gb2312>
		<base target="main">
		<link href='<c:url value="/css/skin.css"/>' rel="stylesheet" type="text/css">
	</head>
	<body leftmargin="0" topmargin="0">
		<table width="100%" height="64" border="0" cellpadding="0" cellspacing="0" style="background-repeat: repeat-x" background='<spring:url value="images/main/top-right.gif"/>'>
			<tr>
				<td width="61%" height="64">
					<img src='<spring:url value="images/main/logo.gif"/>' width="262" height="64">
				</td>
				<td width="39%" valign="top">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="74%" height="38" class="admin_txt">
								您好[<b><security:authentication property="principal.username"/></b>] ,感谢登陆使用！
							</td>
							<td width="22%">
								<a href="#" target="_self" onClick="logout();">
									<img src='<spring:url value="images/main/out.gif"/>' alt="安全退出" width="46" height="20" border="0">
								</a>
							</td>
							<td width="4%">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="19" colspan="3">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
