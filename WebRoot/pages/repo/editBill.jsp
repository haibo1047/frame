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
	<link type="text/css" href="<c:url value="/css/jquery/autocomplete.css"/>" rel="stylesheet" />
  </head>
<script type="text/javascript">
function gotoback(){
	location = '<spring:url value="storage.do"/>';
}

$(function() {
	var projects = [
		{
			value: "jquery",
			label: "jQuery",
			desc: "the write less, do more, JavaScript library",
			icon: "jquery_32x32.png"
		},
		{
			value: "jquery-ui",
			label: "jQuery UI",
			desc: "the official user interface library for jQuery",
			icon: "jqueryui_32x32.png"
		},
		{
			value: "sizzlejs",
			label: "Sizzle JS",
			desc: "a pure-JavaScript CSS selector engine",
			icon: "sizzlejs_32x32.png"
		}
	];

	$( "#drugName" ).autocomplete({
		minLength: 0,
		source: projects,
		focus: function( event, ui ) {
			$( "#drugName" ).val( ui.item.label );
			return false;
		},
		select: function( event, ui ) {
			$( "#drugName" ).val( ui.item.label );
			$( "#drugId" ).val( ui.item.value );
			return false;
		}
	});
});
</script>
  <body>
  	<form:form action="save.do" modelAttribute="bill" name="f1" method="post">
  		单据:<c:out value="${bill.billNo}"></c:out>
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
  		<table>
			<tr>
				<td>
					药品
				</td>
				<td>
					供货单位
				</td>
				<td>
					生产日期
				</td>
				<td>
					数量
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" id="drugName">
				</td>
				<td>
					<input type="text" id="drugId">
				</td>
				<td>
					<input type="text" >
				</td>
				<td>
					<input type="text" >
				</td>
				<td>
					<input type="text" >
				</td>
			</tr>
		</table>
		<table class="mainTable">
			<tr>
				<td class="fm_left"></td>
				<td>
					<span class="f_btn">
						<input type="button" value="确认" onclick="f1.submit()" class="r_btn"/>
					</span>
					<span class="f_btn">
						<input type="button" value="返回" onclick="gotoback()" class="r_btn"/>
					</span>
				</td>
			</tr>
		</table>    
  	</form:form>
  </body>
</html>
