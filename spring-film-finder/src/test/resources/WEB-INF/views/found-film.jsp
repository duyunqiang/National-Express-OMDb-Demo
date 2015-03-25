<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="search-page-link"><a href="<spring:url value="/find-a-film" /> "><span class="glyphicon glyphicon-search"></span> <spring:message code="link.search-again"/></a></div>
<tiles:insertDefinition name="baseTemplate">
	<tiles:putAttribute name="title" value="title.found-film" />
	<tiles:putAttribute name="content" value="/WEB-INF/views/tiles/film-details.jsp" />
</tiles:insertDefinition>
