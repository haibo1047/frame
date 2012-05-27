<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/pages/common/include.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>-</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<link href='<c:url value="/css/common.css"/>' rel="stylesheet" type="text/css">
  </head>
  
  <body>
  
  	<form:form action="doImport.do" method="post" enctype="multipart/form-data" name="f1">
  		上传文件
  		<div class="clum_title"></div>
		<table class="mainTable">
			<tr>
				<td colspan="2">
					<input type="file" name="file">
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
		<a href='<spring:url value="/template/drugTemplate.xls"/>' target="_blank">模板下载</a>
  	</form:form>
  </body>
</html>
