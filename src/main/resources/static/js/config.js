'use strict';

app.config(function($routeProvider, $locationProvider) {
	$locationProvider.html5Mode({
	       enabled: true,
	       requireBase: false
	});
	$locationProvider.hashPrefix('');
	
    $routeProvider
    .when("/", {
        templateUrl : "home.html"
    })
    .when("/user", {
        templateUrl : "view/user.html",
        controller: "userCtrl"
    })
    .when("/book", {
        templateUrl : "view/book.html",
        controller: "bookCtrl"
    })
    .when("/reservation", {
        templateUrl : "view/reservation.html",
        controller: "reservationCtrl"
    })
    .when("/author", {
        templateUrl : "view/author.html",
        controller: "authorCtrl"
    })
    .when("/error", {
        templateUrl : "error.html",
    })
    .otherwise({
		redirectTo : '/'
	});
});