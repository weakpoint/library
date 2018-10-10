app.controller('bookCtrl', function($scope, $http) {
	$http.get("book/getAll.do")
    .then(function(response) {
    	console.log(response)
        $scope.books = response.data;
    });
});