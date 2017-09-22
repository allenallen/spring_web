<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<h1>
	<fmt:message key="accounts.show.title"/>
</h1>
<div id="entityDetails">
	<div id="accountDetails">
		<ul>
			<li>
				<fmt:message key="label.Account.number"/>: ${account.number}
				<spring:url var="editUrl" value="{number}/edit">
					<spring:param name="number" value="${account.number}" />
				</spring:url>
				(<a id="editUrl" href="${editUrl}"><fmt:message key="command.edit" /></a>)
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
