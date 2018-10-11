app.controller('bookCtrl', function($scope, $http, $routeParams) {
	if($routeParams.ID){
		$http.get("book/" + $routeParams.ID)
	    .then(function(response) {
	    	console.log(response)
	        $scope.books = [response.data];
	    });
	} else {
		$http.get("book/getAll.do")
	    .then(function(response) {
	    	console.log(response)
	        $scope.books = response.data;
	    });
	}
});