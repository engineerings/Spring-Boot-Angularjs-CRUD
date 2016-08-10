(function () {
    "use strict";

    angular.module('app.carControllers').controller('CarEditController', CarEditController);

    function CarEditController($scope, $state, $stateParams, Car) {

        //Update the edited car. Send a PUT to /api/v1/cars/:id
        $scope.updateCar = function () {
            
            $scope.car.$update(function () {
                // on success go back to the car list
                $state.go('cars');
            });
        };

        //Send a GET request to /api/v1/cars/:id to get a car to update
        $scope.loadCar = function () {
            $scope.car = Car.get({id: $stateParams.id});
        };

        // Load a car which can be edited on UI
        $scope.loadCar();
    }
}());
