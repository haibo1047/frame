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

function regist(){
	$(".drugName").autocomplete({
		minLength : 2,
		source : drugJsArray,
		focus : function(event, ui) {
			this.value=ui.item.label;
			return false;
		},
		select : function(event, ui) {
			this.value=ui.item.label;
			this.parentElement.getElementsByClassName("drugId")[0].value=ui.item.value;
			return false;
		}
	});
}
function datepick(){
		var pickerOpts = {
	         changeMonth: true,
	         changeYear: true,
	         dateFormat: "yy-mm-dd",
	         dayNamesMin:["一","二","三","四","五","六","日"],
	         firstDay : 0,
			 nextText : "下一月",
			 prevText : "上一月",
			 closeText : "关闭",
			 currentText : "今天",
			 monthNamesShort : [ "一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月",
					"九月", "十月", "十一月", "十二月" ],
			 isRTL : false,
			 showButtonPanel : true,
			 yearRange : "-25:+25"
		};
		$(".datepicker").datepicker(pickerOpts);
	}

	$(function() {
		regist();
		datepick();
	});

	function appendRow() {
		var tr = document.getElementById("copyTr");
		var newtr = tr.cloneNode(true);
		newtr.removeAttribute("id");
		newtr.removeAttribute("style");
		newtr.getElementsByClassName("datepicker")[0].className = "datepicker";
		newtr.getElementsByClassName("datepicker")[0].removeAttribute("id");
		tr.parentNode.appendChild(newtr);
		regist();
		datepick();
	}
</script>
	<body>
  	<form:form action="save.do" modelAttribute="bill" name="f1" method="post">
  		单据:<c:out value="${bill.billNo}"></c:out>
  		<div class="clum_title"></div>
  		<form:hidden path="id"/>
  		<table id="dataTable">
  			<tbody id="dtBody">
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
				<tr id="copyTr" style="display:none">
					<td>
						<input type="text" class="drugName">
						<input type="hidden" name="drugId" class="drugId"/>
					</td>
					<td>
						<form:select path="createUser" items="${providerList}" itemLabel="providerName" itemValue="id"></form:select>
					</td>
					<td>
						<input type="text" name="productDate" readonly="readonly" class="datepicker" value="">
					</td>
					<td>
						<input type="text" name="drugCount">
						<input type="hidden" name="detailId"/>
					</td>
				</tr>
				<c:forEach items="${bill.billDetailSet}" var="billDetail">
					<input type="hidden" name="detailId" value="${billDetail.id}"/>
					<tr>
						<td>
							<input type="text" class="drugName" value="${billDetail.drug.drugName}">
							<input type="hidden" name="drugId" class="drugId" value="${billDetail.drug.id}"/>
						</td>
						<td>
							<select name="createUser">
								<c:forEach items="${providerList}" var="p">
									<option value="${p.id}" <c:if test="${p.id==billDetail.provider.id}">selected</c:if>><c:out value="${p.providerName}"/></option>
								</c:forEach>
							</select>
						</td>
						<td>
							<input type="text" readonly="readonly" class="datepicker" name="productDate" value="${billDetail.productDateString}">
						</td>
						<td>
							<input type="text" name="drugCount" value="${billDetail.drugCount}">
						</td>
					</tr>
				</c:forEach>
  			</tbody>
		</table>
		<a href="#" onclick="appendRow()">+</a>
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
