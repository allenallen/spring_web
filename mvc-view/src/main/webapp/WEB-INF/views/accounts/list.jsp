<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<h1>
	<fmt:message key="accounts.list.title" />
</h1>
<ul class="nav nav-pills">
	<li><a href="accounts.xlsx"><fmt:message key="accounts.list.command.asOffice2007"/></a></li>
	<li><a href="accounts.xls"><fmt:message key="accounts.list.command.asExcel"/></a></li>
	<li><a href="accounts.json"><fmt:message key="accounts.list.command.asJson"/></a></li>
</ul>
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
			</td>
			<td>
				${account.name}
			</td>
		</tr>
	</c:forEach>
</table>
