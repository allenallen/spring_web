<%--

	HINT: The current JSP views have "main" elements. These are view specific.
	Unlike the "nav header", and "footer" elements, which are common across JSP views.

	To complete the layout you will need to define places where content will
	be inserted and use &lt;tiles:insertAttribute ... /&gt;.
	
	The &lt;tiles:insertAttribute name="title" /&gt; has already been done for you.

--%><%@ include file="/WEB-INF/views/_taglibs.jspf"
%><!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message><tiles:insertAttribute name="title"/></fmt:message> - RewardsOnline</title>
	<link href="<c:url value="/favicon.ico" />" rel="icon" type="image/png" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" />
</head>
<body>
	<!-- Insert factored out HTML here -->
</body>
</html>
