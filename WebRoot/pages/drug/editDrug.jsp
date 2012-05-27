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
  	<form:form action="save.do" modelAttribute="object" name="f1" method="post">
  		增加药品
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
		<table class="mainTable">
			<tr>
				<td>药品名称：</td>
				<td>
					<form:input path="drugName"/>
				</td>
			</tr>
			<tr>
				<td>药品类型：</td>
				<td>
					<form:select path="extraInt" items="${drugTypes}" itemLabel="label" itemValue="value"></form:select>
				</td>
			</tr>
			<tr>
				<td>供应商：</td>
				<td>
					<form:select path="extraLong">
						<form:option value="">请选择</form:option>
						<form:options  items="${providers}" itemLabel="providerName" itemValue="id"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td>单位：</td>
				<td>
					<form:input path="drugUnit"/>
				</td>
			</tr>
			<tr>
				<td>保持期(月)：</td>
				<td>
					<form:input path="guaranteeMonth"/>
				</td>
			</tr>
			<tr>
				<td>批准文号：</td>
				<td>
					<form:input path="approvalNumber"/>
				</td>
			</tr>
			<tr>
				<td>规格：</td>
				<td>
					<form:input path="productModel"/>
				</td>
			</tr>
			<tr>
				<td>生产厂商：</td>
				<td>
					<form:input path="manufacturer"/>
				</td>
			</tr>
			<tr>
				<td>剂型：</td>
				<td>
					<form:input path="drugForm"/>
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
