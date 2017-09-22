<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message key="accounts.show.title" /></title>
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
					<li><a href="<c:url value="/accounts" />"><fmt:message key="navigate.accounts" /></a></li>
				</ul>
				<!-- ul class="nav navbar-nav navbar-right"></ul -->
			</div><!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
			<h1>
				<fmt:message key="accounts.show.title"/>
			</h1>
			<div id="entityDetails">
				<div id="accountDetails">
					<ul>
						<li>
							<fmt:message key="label.Account.number"/>: ${account.number}
						</li>
						<li>
							<fmt:message key="label.Account.name"/>: ${account.name}
						</li>
						<li>
							<fmt:message key="label.Account.dateOfBirth"/>: <fmt:formatDate value="${account.dateOfBirth}"/>
						</li>
						<li>
							<fmt:message key="label.Account.email"/>: ${account.email}
						</li>
						<li>
							<fmt:message key="label.Account.receivingMonthlyEmailUpdate"/>: 
							<fmt:message key="label.${account.receivingMonthlyEmailUpdate}"/>
						</li>
					</ul>
				</div>
				<div id="cards">
					<h2>
						<fmt:message key="label.Account.cards"/>
					</h2>
					<c:if test="${!empty account.cards}">
					<table class="table">
						<thead>
							<tr>
								<th>
									<fmt:message key="label.Account.card.number"/>
								</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="card" items="${account.cards}">
								<tr>
									<td>${card.number}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</c:if>
					<c:if test="${empty account.cards}">
						<fmt:message key="accounts.show.label.noCards"/>
					</c:if>
				</div>
			</div>
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