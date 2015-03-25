<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="search-page-link"><a href="/filmfinder/find-a-film"><span class="glyphicon glyphicon-search"></span> <spring:message code="link.search-again"/></a></div>
<tiles:insertDefinition name="baseTemplate">
	<tiles:putAttribute name="title" value="title.found-films" />
	<tiles:putAttribute name="content" value="/WEB-INF/views/tiles/films-table.jsp" />
</tiles:insertDefinition>