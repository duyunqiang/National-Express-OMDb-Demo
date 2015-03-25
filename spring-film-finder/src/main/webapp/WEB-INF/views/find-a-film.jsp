<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<tiles:insertDefinition name="baseTemplate">
	<tiles:putAttribute name="title" value="title.find-a-film" />
 	<tiles:putAttribute name="content" value="/WEB-INF/views/tiles/film-search-form.jsp" />
</tiles:insertDefinition>
<br>
<!-- TODO: This doesn't work. -->
<c:if test="${model.zeroResults}">
	<p>Sorry. You're search returned no results. Try relaxing the criteria.
</c:if>
