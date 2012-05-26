<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>用户登录</title>
		<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #016aa9;
	overflow: hidden;
}

.STYLE1 {
	color: #000000;
	font-size: 12px;
}
-->
</style>
	</head>

	<body  onload="document.loginForm.j_username.focus();">
		<script type="text/javascript">
			function login(){
				document.loginForm.submit();
			}
		</script>
		<form action="<c:url value='/security_check.do'/>" name="loginForm" method="post">
			<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<table width="962" border="0" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td height="235" background='<spring:url value="/images/login/login_03.gif"/>'>
									&nbsp;
									<c:if test="${not empty param.login_error}">
										<div style="text-align: center">
											<font color="red">
											<b>
												 Your login attempt was not successful, try again.<br />
												  Reason:
												   <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />. 
											</b>
										   </font>
										</div>
									</c:if>
								</td>
							</tr>
							<tr>
								<td height="53">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td width="394" height="53" background='<spring:url value="/images/login/login_05.gif"/>'>
												&nbsp;
											</td>
											<td width="206" background='<spring:url value="images/login/login_06.gif"/>'>
												<table width="100%" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td width="16%" height="25">
															<div align="right">
																<span class="STYLE1">用户</span>
															</div>
														</td>
														<td width="57%" height="25">
															<div align="center">
																<input type="text" name='j_username' style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
															</div>
														</td>
														<td width="27%" height="25">
															&nbsp;
														</td>
													</tr>
													<tr>
														<td height="25">
															<div align="right">
																<span class="STYLE1">密码</span>
															</div>
														</td>
														<td height="25">
															<div align="center">
																<input type="password" name="j_password" style="width: 105px; height: 17px; background-color: #292929; border: solid 1px #7dbad7; font-size: 12px; color: #6cd0ff">
															</div>
														</td>
														<td height="25">
															<div align="left">
																<a href="javascript:void" onclick="login()">
																	<img src='<spring:url value="/images/login/dl.gif"/>' width="49" height="18" border="0" alt="">
																</a>
															</div>
														</td>
													</tr>
												</table>
											</td>
											<td width="362" background='<spring:url value="/images/login/login_07.gif"/>'>
												&nbsp;
											</td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td height="213" background='<spring:url value="/images/login/login_08.gif"/>'>
									&nbsp;
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
