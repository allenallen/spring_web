<%@ include file="/WEB-INF/views/_taglibs.jspf" %><%--
	NOTE: The Spring Form Tag library has been added.
	Please see _taglibs.jspf to know the prefix being used.
--%>
<h1>
	<fmt:message key="accounts.edit.title" />
</h1>

<div id="accountDetails">
	<spring:url value="/accounts/{number}" var="accountUrl">
		<spring:param name="number" value="${account.number}" />
	</spring:url>
	<form:form action="${accountUrl}" method="post" modelAttribute="account">
		<fieldset>
			<legend>
				<fmt:message key="accounts.edit.legend" />
			</legend>
			<div class="form-group">
				<label for="name">
					<fmt:message key="label.Account.name" />
				</label>
				<form:input type="text" path="name" cssClass="form-control" />
				<form:errors cssClass="help-block" path="name" />
			</div>
			<div class="form-group">
				<label for="dateOfBirth">
					<fmt:message key="label.Account.dateOfBirth" />
				</label>
				<form:input type="text" path="dateOfBirth" cssClass="form-control" />
				<form:errors cssClass="help-block" path="dateOfBirth" />
			</div>
			<div class="form-group">
				<label for="email">
					<fmt:message key="label.Account.email" />
				</label>
				<form:input type="text" path="email" cssClass="form-control" />
				<form:errors cssClass="help-block" path="email" />
			</div>
			<div class="form-group">
				<div class="checkbox">
					<label>
						<form:checkbox path="receivingMonthlyEmailUpdate"/>
						<fmt:message key="label.Account.receivingMonthlyEmailUpdate" />
					</label>
				</div>
			</div>
			<div class="form-group">
				<button id="saveButton" class="btn btn-default" type="submit">
					<fmt:message key="command.save" />
				</button>
				<a class="btn btn-link" role="button" href="${accountUrl}">
					<fmt:message key="command.cancel" />
				</a>
			</div>
		</fieldset>
	</form:form>
</div>