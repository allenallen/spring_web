<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<h1>
	<fmt:message key="accounts.list.title" />
</h1>
<div class="row">
	<c:url var="accountsUrl" value="accounts" />
	<form:form id="searchForm" class="form-inline col-xs-12 col-sm-6" action="${accountsUrl}" modelAttribute="accountSearchCriteria" method="get">
		<div class="form-group">
			<form:input class="form-control" path="searchString" />
		</div>
		<div class="form-group">
			<button id="searchButton" type="submit" class="btn btn-default"><fmt:message key="command.search"/></button>
		</div>
	</form:form>
</div>
<c:if test="${accountSearchCriteria.searchString.length() > 0}">
<h2>Matches for <span style="font-style: italic"><c:out value="${accountSearchCriteria.searchString}" /></span></h2>
</c:if>
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
			<td>
				<spring:url var="showUrl" value="accounts/{number}">
					<spring:param name="number" value="${account.number}" />
				</spring:url>
				<a href="${showUrl}">${account.number}</a>
				<spring:url var="editUrl" value="accounts/{number}/edit">
					<spring:param name="number" value="${account.number}" />
				</spring:url>
				(<a id="editUrl" href="${editUrl}"><fmt:message key="command.edit" /></a>)
			</td>
			<td>
				${account.name}
			</td>
		</tr>
	</c:forEach>
</table>
