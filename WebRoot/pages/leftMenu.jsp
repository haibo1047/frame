<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>管理页面</title>

		<script type="text/javascript" src="<c:url value="/js/prototype.lite.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/moo.fx.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/moo.fx.pack.js"/>"></script>
		<link type="text/css" href="<c:url value="/css/menu.css"/>" rel="stylesheet" />

		<style>
		body {
	font: 12px Arial, Helvetica, sans-serif;
	color: #000;
	background-color: #EEF2FB;
	margin: 0px;
}
		</style>
	</head>

	<body>
	<script type="text/javascript">
		function openMenu(url){
		}
	</script>
		<table width="100%" height="280" border="0" cellpadding="0" cellspacing="0" bgcolor="#EEF2FB">
			<tr>
				<td width="182" valign="top">
					<div id="container">
						<c:forEach items="${firstLevel}" var="first">
							<h1 class="type">
								<a href="javascript:void(0)"><c:out value="${first}"/></a>
							</h1>
							<div class="content">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td>
											<img src='<spring:url value="images/main/menu_topline.gif"/>' width="182" height="5" />
										</td>
									</tr>
								</table>
								<ul class="MM">
									<c:forEach items="${menuMap.get(first)}" var="menu">
										<li>
											<a href="${ctx}${menu.menuUrl}" target="main"><c:out value="${menu.menuName}"/></a>
										</li>
									</c:forEach>
								</ul>
							</div>
						</c:forEach>
					</div>
				</td>
			</tr>
		</table>
	<script type="text/javascript">
		var contents = document.getElementsByClassName('content');
		var toggles = document.getElementsByClassName('type');
	
		var myAccordion = new fx.Accordion(toggles, contents, {
			opacity : true,
			duration : 400
		});
		myAccordion.showThisHideOpen(contents[0]);
	</script>
	</body>
</html>
