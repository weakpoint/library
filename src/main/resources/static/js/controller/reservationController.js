app.controller('reservationCtrl', function($scope, $http) {
	$http.get("reservation/getAll.do")
    .then(function(response) {
    	console.log(response)
        $scope.reservations = response.data;
    });
});