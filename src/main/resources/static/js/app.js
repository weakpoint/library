'use strict';

String.prototype.format = function () {
    var formatted = this;
    for (var i = 0; i < arguments.length; i++) {
        formatted = formatted.replace(
            new RegExp('\\{\\}'), arguments[i]);
    }
    return formatted;
};

var app = angular.module('library', ["ngRoute"]);