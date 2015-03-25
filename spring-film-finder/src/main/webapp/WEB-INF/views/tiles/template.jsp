<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html><head>
<tiles:importAttribute name="title"/>
<title><spring:message code="${title}"/></title>
<tiles:insertAttribute name="scripts-and-styles" />
</head>
<body>
	<div class="container">
		<header><div id="the_header" class="jumbotron">
		<h1><spring:message code="${title}"/></h1></div></header>
		<div id="content">
			<tiles:insertAttribute name="content" />
		</div>
	</div>
	<span id="locale_choice">Language : <a href="?locale=en">English</a>|<a href="?locale=fr">Francais</a></span>
	<footer><span id="the_footer"><tiles:insertAttribute name="footer" /></span></footer>
</body>
</html>
