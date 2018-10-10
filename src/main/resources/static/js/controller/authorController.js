app.controller('authorCtrl', function($scope, $http) {
	$http.get("author/getAll.do")
    .then(function(response) {
    	console.log(response)
        $scope.authors = response.data;
    });
});