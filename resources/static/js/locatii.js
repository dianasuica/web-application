/*global angular*/
"use strict";
// var app = angular.module('app', []);

angular.module('app').controller('locatii', function($scope, $http, $uibModal, $log){

    $scope.sortKey = 'idLocatie';
    $scope.reverse = false;

    $http({
        method: 'GET',
        url: 'api/locatii/all'
    }).then(function (response){
        $scope.locatiiList = response.data;
        console.log("success!");
    },function (error){
        console.error('Error occurred:', error);
    });

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.open = function(departamente){

        var modalInstance = $uibModal.open({
            animation: true,
            ariaLabelledBy: 'modal-title',
            ariaDescribedBy: 'modal-body',
            templateUrl: '/modals/modalDepartamente.html',
            controller: 'ModalDepartamenteCtrl',
            controllerAs: 'pc',
            size: 'lg',
            resolve: {
                listaDepartamente: function () {
                    return departamente;
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

angular.module('app').controller('ModalDepartamenteCtrl', function ($uibModalInstance, listaDepartamente) {

    var pc = this;
    pc.listaDepartamente = listaDepartamente;

    pc.ok = function () {
        $uibModalInstance.close();
    };

    pc.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});