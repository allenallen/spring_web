<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<div class="row">
<c:if test="${param.error != null}">
	<div class="col-xs-12 bg-warning" style="padding: 15px">
		<fmt:message key="login.unsuccessful"/>
	</div>
</c:if>
<c:if test="${param.logout != null}">
	<div class="col-xs-12 bg-info" style="padding: 15px">
		<fmt:message key="logout.successful"/>
	</div>
</c:if>
</div><%--

The values used in the form depends on the attributes specified
in the security configuration:
- login-processing-url (defaults to "/login")
- username-parameter (defaults to "username")
- password-parameter (defaults to "password")

--%>
<div class="row">
<spring:url value="/login" var="securityCheckUrl" />
<form:form action="${securityCheckUrl}" method="post" class="col-xs-12 col-md-6">
	<div class="help-block"><fmt:message key="login.hint"/></div>
	<div class="form-group">
		<label for="username"><fmt:message key="login.user"/></label>
		<input class="form-control" type="text" id="username" name="username" value="<c:out value='${user}'/>" />
	</div>
	<div class="form-group">
		<label for="password"><fmt:message key="login.password"/></label>
		<input class="form-control" type="password" id="password" name="password" />
	</div>
	<div class="form-group">
		<div class="checkbox">
			<label>
				<input type="checkbox" name="_spring_security_remember_me"/>
				<fmt:message key="login.remember"/>
			</label>
		</div>
	</div>
	<div class="form-group">
		<button class="btn btn-default" type="submit"><fmt:message key="login.submit"/></button>
	</div>
</form:form>
</div>
