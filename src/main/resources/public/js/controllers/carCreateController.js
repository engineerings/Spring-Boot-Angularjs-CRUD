(function () {
    "use strict";

    angular.module('app.carControllers').controller('CarCreateController', CarCreateController);

    function CarCreateController($scope, $state, $stateParams, Car) {

        $scope.car = new Car();

        //create a new car. Send a POST to /api/v1/cars
        $scope.addCar = function () { 
            $scope.car.$save(function () {
                // on success go back to the car list
                $state.go('cars');
            });
        };
    }
    
}());
