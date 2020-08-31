/*global angular*/
"use strict";
// var app = angular.module('app', []);

angular.module('app').controller('clienti', function($scope, $http, $uibModal, $log){

    $scope.sortKey = 'idClient';
    $scope.reverse = false;

    $http({
        method: 'GET',
        url: 'api/clienti/all'
    }).then(function (response){
        $scope.clientList = response.data;
        console.log("success!");
    },function (error){
        console.error('Error occurred:', error);
    });

    $scope.sort = function(keyname){
        $scope.sortKey = keyname;   //set the sortKey to the param passed
        $scope.reverse = !$scope.reverse; //if true make it false and vice versa
    };

    $scope.open = function(conturi){
        console.log(conturi);
         var modalInstance = $uibModal.open({
             animation: true,
             ariaLabelledBy: 'modal-title',
             ariaDescribedBy: 'modal-body',
             templateUrl: '/modals/modalConturi.html',
             controller: 'ModalInstanceCtrl',
             controllerAs: 'pc',
             size: 'lg',
             resolve: {
                listaConturi: function () {
                    return conturi;
                }
            }
        });

        modalInstance.result.then(function () {
            console.log("closed");
        }, function () {
            console.log('dismissed');
        })
    };

    $scope.medie = function(){
        $http({
            method: 'GET',
            url: 'api/cheltuieli/medie/'+$scope.id
        }).then(function (response){
            $scope.medii = response.data.medii;
            $scope.luni = response.data.luni;
            $scope.series = ['Series A'];
            $scope.datasetOverride = [{ yAxisID: 'y-axis-1' }];
            $scope.options = {
                scales: {
                    yAxes: [
                        {
                            id: 'y-axis-1',
                            type: 'linear',
                            display: true,
                            position: 'left'
                        }
                    ]
                }
            };
            console.log("success!");
        },function (error){
            console.error('Error occurred:', error);
        });
    };

});

angular.module('app').controller('ModalInstanceCtrl', function ($uibModalInstance, listaConturi) {

    var pc = this;
    pc.listaConturi = listaConturi;

    pc.ok = function () {
        $uibModalInstance.close();
    };

    pc.cancel = function () {
        $uibModalInstance.dismiss('cancel');
    };
});