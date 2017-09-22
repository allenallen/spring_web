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
	<!-- TODO 01b1: Use Spring form tag for this form -->
	<!-- Use the "accountUrl" variable already defined above -->
	<form action="" method="post">
		<fieldset>
			<legend>
				<fmt:message key="accounts.edit.legend" />
			</legend>
			<div class="form-group">
				<label for="name">
					<fmt:message key="label.Account.name" />
				</label>
				<!-- TODO 01b2: Add input control for account name -->
				<!-- Hint: Use Spring's Form tag library -->
			</div>
			<div class="form-group">
				<label for="dateOfBirth">
					<fmt:message key="label.Account.dateOfBirth" />
				</label>
				<!-- TODO 01b3: Add input control for account holder's date of birth -->
			</div>
			<div class="form-group">
				<label for="email">
					<fmt:message key="label.Account.email" />
				</label>
				<!-- TODO 01b4: Add input control for account holder's email -->
			</div>
			<div class="form-group">
				<div class="checkbox">
					<label>
						<!-- TODO 01b5: Add input control *and label* for account holder's preference to receive monthly email updates -->
					</label>
				</div>
			</div>
			<div class="form-group">
				<button id="saveButton" class="btn btn-default" type="submit">
					<fmt:message key="command.save" />
				</button>
				<!-- TODO 01b6: Add cancel command which is really a link and not a button -->
				<!-- The link goes back to *show* the account being edited -->
				<a class="btn btn-link" role="button" href="">
					<fmt:message key="command.cancel" />
				</a>
			</div>
		</fieldset>
	</form>
</div>