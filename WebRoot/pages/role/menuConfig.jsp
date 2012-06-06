<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>configRole</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
	<script type="text/javascript" src="<c:url value="/js/select.js"/>"></script>
	<script>
	init("unselectElement","selectedElement");
	function saveConfigRole(){
		var ops = document.getElementById("selectedElement").options;
		for(var index=0;index<ops.length;index++){
			ops[index].selected = true;
		}
		document.f1.submit();
	}
	</script>
  </head>
  
  <body>
  	<form:form modelAttribute="object" action="saveConfigRole.do" method="post" name="f1">
  		<form:hidden path="id"/>
  		配置菜单
  		<div class="clum_title"></div>
		<table class="mainTable">
			<tr>
				<td>
					未选菜单
				</td>
				<td></td>
				<td>
					已选菜单
				</td>
			</tr>
			<tr>
				<td>
					<form:select path="unselect" id="unselectElement" multiple="true" size="15"
						items="${unselect}" itemLabel="menuPath" itemValue="id"
						ondblclick="moveIt(this,selectedElement,1)" cssStyle="width:160px;">
					</form:select>
				</td>
				<td>
					<input type="button" value="--->" onclick="onClick='javascript:moveIt(unselectElement,selectedElement,1)'">
					<br>
					<input type="button" value="&lt;---" onclick="onClick='javascript:moveIt(unselectElement,selectedElement,2)'">
				</td>
				<td>
					<form:select path="selected" id="selectedElement" multiple="true" size="15"
						items="${selected}"  itemLabel="menuPath" itemValue="id"
						ondblclick="moveIt(this,unselectElement,2)" cssStyle="width:160px;">
					</form:select>
				</td>
			</tr>
			
			<tr>
				<td colspan="3" align="center">
					<span class="f_btn">
						<input type="button" value="确认" onclick="saveConfigRole()" class="r_btn"/>
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
