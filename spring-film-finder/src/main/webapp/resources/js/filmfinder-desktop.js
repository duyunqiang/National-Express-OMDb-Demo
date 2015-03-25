$(document).ready(function() {

	// omdbapi.com only returns a maximum of 10 search results (see change log 2/14/13)
	// but in case that changes, this datatable will provide paging, as well as lots of other nice features.
	$('#filmResultsTable, #filmDetailsTable').dataTable();

	$('#filmResultsTable tbody tr').dblclick(function() {
		window.open('found-film/' + this.dataset.imdbId, '_self');
	});
});
