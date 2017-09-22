<%-- TODO 01b: Factor our layout from this JSP (/WEB-INF/views/accounts/list.jsp)

The factored out HTML should be placed in /WEB-INF/_layouts/standard.jsp.
Only the view-specific contents should be left in this JSP.

--%>

<div class="container">
	<h1>
		<fmt:message key="accounts.list.title" />
	</h1>
	<table class="table">
		<thead>
			<tr>
				<th><fmt:message key="label.Account.number" /></th>
				<th><fmt:message key="label.Account.name" /></th>
			</tr>
		</thead>
		<c:forEach var="account" items="${accounts}">
			<tr>
				<!-- <td>
						<a href="accounts/${account.number}">${account.number}</a>
					</td>-->
				<td><spring:url var="showUrl" value="accounts/{number}">
						<spring:param name="number" value="${account.number}" />
					</spring:url> <a href="${showUrl}">${account.number}</a></td>
				<td>${account.name}</td>
			</tr>
		</c:forEach>
	</table>
</div>

