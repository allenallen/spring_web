<%@ include file="/WEB-INF/views/_taglibs.jspf" %>
<div class="page-header">
	<h1>Access Denied</h1>
</div>
<p class="lead">Sorry, access denied.</p>
<p><a href="<c:url value='/' />" class="btn btn-link">Return to Home Page</a></p>
<p><c:url var="logoutUrl" value='/logout' />
	<form:form action="${logoutUrl}" method="post" role="form" class="form-horizontal"><input type="submit" value="Logout" class="btn btn-link"/></form:form>
</p>	
