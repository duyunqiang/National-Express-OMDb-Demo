<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- TODO: language pack -->
<div id="filmDetails">
	<div class="row">
		<div class="col-xs-12">
			<h2>${movie.title}</h2>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-4">
			<p>${movie.title} was <c:if test="${movie.genre ne null and movie.genre ne 'N/A'}">a ${movie.genre} </c:if>
				<c:if test="${movie.year ne null and movie.year ne 'N/A'}">made in ${movie.year}, </c:if>
				<c:if test="${movie.writer ne null and movie.writer ne 'N/A'}">written by ${movie.writer}</c:if>
				<c:if test="${movie.director ne null and movie.director ne 'N/A'}">, and directed by ${movie.director}</c:if>. 
				It <c:if test="${movie.actors ne null and movie.actors ne 'N/A'}">starred ${movie.actors}</c:if>
				<c:if test="${movie.released ne null and movie.released ne 'N/A'}">, and was released on ${movie.released}</c:if>.
		</div>
		<div class="col-xs-4">
			<p><c:choose><c:when test="${movie.released ne null and movie.released ne 'N/A'}">With a runtime of ${movie.runtime}, this</c:when>
			<c:otherwise>This</c:otherwise></c:choose> is the plot:
			<p>${movie.plot}
		</div>
		<div class="col-xs-4">
			<p><c:choose><c:when test="${movie.country ne null and movie.country ne 'N/A'}">Filmed in ${movie.country}, <c:if test="${movie.language ne null and movie.language ne 'N/A'}">the</c:if>
			</c:when><c:otherwise>
			<c:if test="${movie.language ne null and movie.language ne 'N/A'}">The</c:if></c:otherwise></c:choose>
			<c:if test="${movie.language ne null and movie.language ne 'N/A'}"> original language was ${movie.language}.</c:if>
			<p>It <c:if test="${movie.awards ne null and movie.awards ne 'N/A'}">won the following awards: ${movie.awards}. </c:if>
			<p>It is <c:choose><c:when test="${movie.imdbRating ne null and movie.imdbRating ne 'N/A'}">rated ${movie.imdbRating} </c:when>
			<c:otherwise>unrated  </c:otherwise></c:choose>by IMDB.
		</div>
	</div>
	<p><a href="https://en.wikipedia.org/wiki/?search=${movie.title}">Wikipedia</a>
	<c:if test="${movie.poster ne null and movie.poster ne 'N/A'}"><br><div id="poster-image"><img src="${movie.poster}"></div></c:if>
</div>
