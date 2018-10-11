app.controller('authorCtrl', function($scope, $http, $routeParams) {
	
	if($routeParams.ID){
		$http.get("author/" + $routeParams.ID)
	    .then(function(response) {
	    	console.log(response)
	        $scope.authors = [response.data];
	    });
	} else {
		$http.get("author/getAll.do")
	    .then(function(response) {
	    	console.log(response)
	        $scope.authors = response.data;
	    });
	}
});