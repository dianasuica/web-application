/*global angular*/
"use strict";
// var app = angular.module('app', []);

app.controller('angajati', function($scope,$http,$uibModal, $log){

    $scope.sortKey = 'idAng';
    $scope.reverse = false;

    $http({
        method: 'GET',
        url: 'api/angajati/all'
    }).then(function (response){
        $scope.angajatiList = response.data;
        console.log("success!");
    },function (error){
        console.error('Error occurred:', error);
    });

    $http({
        method: 'GET',
        url: 'api/angajati/medieVarsta'
    }).then(function (response){
        $scope.departamente = response.data.departamente;
        $scope.medii = response.data.medie;
        console.log("success!");
    },function (error){
        console.error('Error occurred:', error);
    });

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.open = function(functie){

        var modalInstance = $uibModal.open({
            animation: true,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: '/modals/modalFunctie.html',
            controller: 'ModalFunctieCtrl',
            controllerAs: 'pc',
            size: 'lg',
            resolve: {
                functie: function () {
                    return functie;
                }
            }
        });

        modalInstance.result.then(function () {
            console.log("closed");
        }, function () {
            console.log('dismissed');
        })
    };

});

angular.module('app').controller('ModalFunctieCtrl', function ($uibModalInstance, functie) {

    var pc = this;
    pc.functie = functie;

    pc.ok = function () {
        $uibModalInstance.close();
    };

    pc.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});