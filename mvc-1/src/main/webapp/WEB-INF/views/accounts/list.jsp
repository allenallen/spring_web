<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message key="accounts.list.title" /></title>
	<link href="<c:url value="/images/onb_logo_tiny.ico" />" rel="icon" type="image/png" />
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
					<li><a href="<c:url value="accounts" />"><fmt:message key="navigate.accounts" /></a></li>
				</ul>
				<!-- ul class="nav navbar-nav navbar-right"></ul -->
			</div><!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<h1><fmt:message key="accounts.list.title" /></h1>
		<table class="table">
			<thead>
				<tr>
					<th>
						<fmt:message key="label.Account.number"/>
					</th>
					<th>
						<fmt:message key="label.Account.name"/>
					</th>
				</tr>
			</thead>
			<c:forEach var="account" items="${accounts}">
				<tr>
					<!-- TODO 04e: Use Spring's <url> tag -->
					<!-- Use Spring's <url> tag to create a URI template with the account number -->
					<td>
						<a href="accounts/${account.number}">${account.number}</a>
					</td>
					<!-- TODO 04f: Run the web-app again and click on a specific account -->
					<td>
						${account.name}
					</td>
				</tr>
			</c:forEach>
		</table>
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