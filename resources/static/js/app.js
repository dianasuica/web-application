/*global angular*/
"use strict";
var app = angular.module('app', ['ngRoute','angularUtils.directives.dirPagination','ngAnimate', 'ngSanitize', 'ui.bootstrap','chart.js']);

app.config(function ($routeProvider, $locationProvider) {
    //configurare rute
    $locationProvider.hashPrefix('');
    $routeProvider
        .when('/angajati', {
            templateUrl: '/pages/list-angajati.html',
            controller: 'angajati'
        })
        .when('/clienti', {
            templateUrl: '/pages/list-clienti.html',
            controller: 'clienti'
        })
        .when('/departamente', {
            templateUrl: '/pages/list-departamente.html',
            controller: 'departamente'
        })
        .when('/locatii', {
            templateUrl: '/pages/list-locatii.html',
            controller: 'locatii'
        })
        .otherwise ({
            redirectTo: '/'
        });
});

app.run(function ($rootScope, $http) {

});
