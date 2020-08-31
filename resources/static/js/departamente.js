/*global angular*/
"use strict";
// var app = angular.module('app', []);

app.controller('departamente', function($scope,$http){

    $scope.sortKey = 'idDepartament';
    $scope.reverse = false;

    $http({
        method: 'GET',
        url: 'api/departamente/all'
    }).then(function (response){
        $scope.departamentList = response.data;
        console.log("success!");
    },function (error){
        console.error('Error occurred:', error);
    });

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

});
