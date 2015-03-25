<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- jquery 2 doesn't support IE<9. So we might have to provide a fallback. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<c:choose>
	<c:when test="${isSmallScreenDevice}">
<!-- small screen -->
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jquerymobile/1.4.5/jquery.mobile.min.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jquerymobile/1.4.5/jquery.mobile.min.js"></script>
		
		<link rel="stylesheet" href="<c:url value="/resources/css/filmfinder-small-screen.css" />" type="text/css" />
		<script src="<c:url value="/resources/js/filmfinder-small-screen.js" />"></script>
	</c:when>
	<c:otherwise>
<!-- desktop -->
		<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/themes/smoothness/jquery-ui.css" />
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.3/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="https://cdn.datatables.net/plug-ins/f2c75b7247b/integration/jqueryui/dataTables.jqueryui.css" />
		<script src="https://cdn.datatables.net/1.10.5/js/jquery.dataTables.min.js"></script>
		<script src="https://cdn.datatables.net/plug-ins/f2c75b7247b/integration/jqueryui/dataTables.jqueryui.js"></script>
		
		<link rel="stylesheet" href="<c:url value="/resources/css/filmfinder-desktop.css" />" type="text/css" />
		<script src="<c:url value="/resources/js/filmfinder-desktop.js" />"></script>
	</c:otherwise>
</c:choose>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="<c:url value="/resources/css/filmfinder.css" />" type="text/css" />
<script src="<c:url value="/resources/js/filmfinder.js" />"></script>