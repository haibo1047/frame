<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>
<html>
	<head>
		<title>menu</title>
		<link type="text/css" href="<c:url value="/css/menu/ddsmoothmenu.css"/>" rel="stylesheet" />
		<script type="text/javascript" src="<c:url value="/js/ddsmoothmenu.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/js/jquery-1.7.2.min.js"/>"></script>
	</head>

	<body>
		<script type="text/javascript">
			ddsmoothmenu.init({
				mainmenuid : "smoothmenu2", //menu DIV id
				orientation : 'h', //Horizontal or vertical menu: Set to "h" or "v"
				classname : 'ddsmoothmenu', //class added to menu's outer DIV
				//customtheme: ["#1c5a80", "#18374a"],
				contentsource : "markup" //"markup" or ["container_id", "path_to_menu_file"]
			});
		</script>
		<div id="smoothmenu2">
			<ul>
				<c:forEach items="${menu.subMenuList}" var="first">
					<li>
						<a href='<spring:url value="${first.menuUrl}"/>'><c:out value="${first.menuName}"/></a>
						<c:if test="${not empty first.subMenuList}">
							<ul>
								<c:forEach items="${first.subMenuList}" var="second">
									<li>
										<a href='<spring:url value="${second.menuUrl}"/>'><c:out value="${second.menuName}"/></a>
										<c:if test="${not empty second.subMenuList}">
											<ul>
												<c:forEach items="${second.subMenuList}" var="third">
													<li>
														<a href='<spring:url value="${third.menuUrl}"/>'><c:out value="${third.menuName}"/></a>
													</li>
												</c:forEach>
											</ul>
										</c:if>
									</li>
								</c:forEach>
							</ul>
						</c:if>
					</li>
				</c:forEach>
			</ul>
		</div>
	
	</body>
</html>