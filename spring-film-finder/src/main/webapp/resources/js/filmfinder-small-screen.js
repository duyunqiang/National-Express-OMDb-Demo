$(document).ready(function() {
	
	$('#searchButton').addClass('btn-block');
	
	// omdbapi.com only returns a maximum of 10 search results (see change log 2/14/13)
	// but in case that changes, this datatable will provide paging, as well as lots of other nice features.
    $('#filmResultsTable').addClass('ui-responsive');

    // Single-click for touch-devices.
	$('#filmResultsTable tbody tr').click(function() {
		window.open('found-film/' + this.dataset.imdbId, '_self');
	});
} );
