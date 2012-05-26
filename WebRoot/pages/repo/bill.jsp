<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/pages/common/include.jsp"%>

<html>
<head>
	<title>jQuery UI Autocomplete - Default functionality</title>
	<script type="text/javascript" src="<c:url value="/js/jquery-1.7.2.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.core.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.widget.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.position.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/js/jquery.ui.autocomplete.js"/>"></script>
	<link type="text/css" href="<c:url value="/css/jquery/autocomplete.css"/>" rel="stylesheet" />
	<script>
	$(function() {
		var availableTags = [
			"ActionScript-1101",
			"AppleScript-1102",
			"Asp-1103",
			"BASIC",
			"C",
			"C++",
			"Clojure",
			"COBOL",
			"ColdFusion",
			"Erlang",
			"Fortran",
			"Groovy",
			"Haskell",
			"Java",
			"JavaScript",
			"Lisp",
			"Perl",
			"PHP",
			"Python",
			"Ruby",
			"Scala",
			"Scheme"
		];
		$( "#tags" ).autocomplete({
			source: availableTags
		});
	});
	</script>
</head>
<body>
	
<div class="demo">

<div class="ui-widget">
	<label for="tags">Tags: </label>
	<input id="tags" />
</div>

</div>

</body>
</html>
