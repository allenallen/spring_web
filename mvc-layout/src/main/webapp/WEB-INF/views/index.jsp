<%-- TODO 01: Factor out common layouts from JSPs (to create /WEB-INF/views/_layouts/standard.jsp) --%>
<%-- TODO 01a: Factor out layout from this JSP (/WEB-INF/views/index.jsp) --%>
<%@ include file="/WEB-INF/views/_taglibs.jspf"
%><!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message key="welcome.title" /></title>
	<link href="<c:url value="/favicon.ico" />" rel="icon" type="image/png" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" />
</head>
<body>
	<nav class="navbar navbar-default navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">RewardsOnline</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<c:url value="/" />"><fmt:message key="navigate.home" /></a></li>
					<li><a href="<c:url value="/accounts" />"><fmt:message key="navigate.accounts" /></a></li>
				</ul>
				<!-- ul class="nav navbar-nav navbar-right"></ul -->
			</div><!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<div class="page-header">
			<h1><fmt:message key="welcome.title" /></h1>
		</div>
		<p class="lead"><fmt:message key="welcome.caption" /></p>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted"><fmt:message key="footer.message"/></p>
		</div>
    </footer>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value='/webjars/jquery/1.11.1/jquery.min.js' />"></script>
<script src="<c:url value='/webjars/bootstrap/3.3.6/js/bootstrap.min.js' />"></script>
</body>
</html>
