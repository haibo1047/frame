<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>edit..</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<c:url value="/js/jquery-1.7.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.widget.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.position.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.autocomplete.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery-ui-datepicker.min.js"/>"></script>
	<link type="text/css" href="<c:url value="/css/jquery/autocomplete.css"/>" rel="stylesheet" />
	<link type="text/css" href="<c:url value="/css/jquery/datepicker.css"/>" rel="stylesheet" />
	<script type="text/javascript" src="<c:url value="/js/drug.do"/>"></script>
  </head>
<script type="text/javascript">
function gotoback() {
	location = '<spring:url value="storage.do"/>';
}
</script>
	<body>
  	<form:form action="saveBill.do" method="post" modelAttribute="bill" name="f1">
  		增加${bill.billType.label}
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
  		<form:hidden path="billType"/>
		<table class="mainTable">
			<tr>
				<td>仓库:</td>
				<td>
					<form:select path="repositoryString" items="${repositoryList}" itemLabel="repositoryName" itemValue="id"></form:select>
				</td>
			</tr>
			<tr>
				<td>供应商名称:</td>
				<td>
					<form:select path="providerString" items="${providerList}" itemLabel="providerName" itemValue="id"></form:select>
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
