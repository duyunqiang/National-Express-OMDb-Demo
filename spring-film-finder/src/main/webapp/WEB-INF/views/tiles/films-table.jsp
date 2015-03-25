<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<h2>
	<spring:message code="header2.found-these-films" arguments="${filmCount}"/>
</h2>

<table id="filmResultsTable" data-role="table" class="table-striped table-hover">
	<thead>
		<tr>
			<th>IMDB ID</th>
			<th><spring:message code="table-header.title"/></th>
			<th><spring:message code="table-header.year"/></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${searchResults}" var="movie">
			<tr data-imdb-id='${movie.imdbID}'>
				<td><span class="glyphicon glyphicon-film"></span> ${movie.imdbID}</td>
				<td>${movie.title}</td>
				<td>${movie.year}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>