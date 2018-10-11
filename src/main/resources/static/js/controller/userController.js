app.controller('userCtrl', function($scope, $http, $routeParams) {
	console.log($routeParams);
	
	if($routeParams.ID){
		$http.get("user/" + $routeParams.ID)
	    .then(function(response) {
	    	console.log(response)
	        $scope.users = [response.data];
	    });
	} else {
		$http.get("user/getAll.do")
	    .then(function(response) {
	    	console.log(response)
	        $scope.users = response.data;
	    });
	}
});