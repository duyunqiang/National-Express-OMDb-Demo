<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!-- This uses both HTML5 validation, and failing that (in older browsers, gets validated by Spring on the server. -->
<form:form role="form"  method="POST" action="find-a-film" modelAttribute="filmSearchTerms">
	<fieldset id="filmSearchFields">
		<div class="form-group">
		<form:label path="title"><spring:message code="label.enter-title"/></form:label>
		<form:input path="title" size="50" cssClass="form-control" required="true" />
		<form:errors path="title" cssClass="text-danger" />
		</div>
		<div class="form-group">
		<form:label path="type"><spring:message code="label.enter-type"/></form:label>
		<form:select path="type" cssClass="form-control">
			<form:options items="${filmTypes}" />
		</form:select>
		</div>
		<div class="form-group">
		<form:label path="year"><spring:message code="label.enter-year"/></form:label>
		<form:input path="year"  cssClass="form-control" type="number" size="4" min="1850" max="2050"/>
		<form:errors path="year" cssClass="text-danger" />
		</div>
		<button  id="searchButton" type="submit" value="Search" class="form-control btn btn-default"><spring:message code="button.search"/> <span class="glyphicon glyphicon-search"></span></button>
	</fieldset>
</form:form>
