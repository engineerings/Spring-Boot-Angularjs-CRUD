(function () {
    "use strict";

    angular.module('app.carControllers').controller('CarListController', CarListController);

    function CarListController($scope, $state, popupService, $window, Car) {

        //fetch all cars. Send a GET to /api/vi/cars
        $scope.cars = Car.query();

        // Delete a Car. Send a DELETE to /api/v1/cars/:id
        $scope.deleteCar = function (car) {
            if (popupService.showPopup('Are you really want to  delete this car?')) {
                car.$delete(function () {
                    $scope.cars = Car.query();
                    $state.go('cars');
                });
            }
        };
    }
}());
