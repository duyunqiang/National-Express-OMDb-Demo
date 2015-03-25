<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Something has gone very wrong</title>
</head>
<body>
<h1>Please except my apologies. An error has occurred.</h1>
<br><br>
<div id="search-page-link"><a href="/filmfinder/find-a-film"><span class="glyphicon glyphicon-home"></span> Back to the search page</a></div>
<br><br>
<audio loop="loop" autoplay><source src="<spring:url value="/resources/sounds/star_wars_klaxon.mp3" /> " type="audio/mpeg"></audio>
<div id="error-image"><img src="<spring:url value="/resources/images/fatal-error.jpg" />" /></div>
</body>
</html>