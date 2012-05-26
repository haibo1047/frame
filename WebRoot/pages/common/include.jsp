<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ec" uri="http://www.extremecomponents.org"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<link type="text/css" href="<c:url value="/css/extreme.css"/>" rel="stylesheet" />
<link type="text/css" href="<c:url value="/css/common.css"/>" rel="stylesheet" />

<script type="text/javascript">
  	function goback(){
  		location = "${ctx}/${objectDir}/list.do";
  	}
</script>