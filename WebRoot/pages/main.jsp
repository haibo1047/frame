<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<title>-<c:out value="${systemName}"/></title>
		<meta http-equiv=Content-Type content=text/html;charset=gb2312>
	</head>
	<script>
		window.history(-1).foward(1);
	</script>
	<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
		<frame src='<spring:url value="top.do"/>' noresize="noresize" frameborder="NO"
			name="topFrame" scrolling="no" marginwidth="0" marginheight="0"
			target="main" />
		<frameset cols="200,*" rows="560,*" id="frame">
			<frame src='<spring:url value="leftMenu.do"/>' name="leftFrame" noresize="noresize"
				marginwidth="0" marginheight="0" frameborder="0" scrolling="no"
				target="main" />
			<frame src="" name="main" marginwidth="0" marginheight="0"
				frameborder="0" scrolling="auto" target="_self" />
		</frameset>
		<noframes>
			<body></body>
		</noframes>
	</frameset>
</html>
