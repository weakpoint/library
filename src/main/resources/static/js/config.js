'use strict';

app.config(function($routeProvider) {
    $routeProvider
    .when("/", {
        templateUrl : "home.html"
    })
    .when("/user", {
        templateUrl : "user.html"
    })
    .when("/book", {
        templateUrl : "book.html"
    })
    .when("/reservation", {
        templateUrl : "reservation.html"
    })
    .when("/author", {
        templateUrl : "author.html"
    });
});