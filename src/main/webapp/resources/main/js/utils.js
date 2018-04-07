/**
 * 
 */
function executeFilter(event, grid) {
	if ((event.keyCode || event.which) == 13) {
		PF(grid).filter();
		event.preventDefault();
     }

}
