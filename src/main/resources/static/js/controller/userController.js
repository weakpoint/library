app.controller('userCtrl', function($scope, $http) {
	$http.get("user/getAll.do")
    .then(function(response) {
    	console.log(response)
        $scope.users = response.data;
    });
});