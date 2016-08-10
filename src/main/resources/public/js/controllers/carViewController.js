(function () {
    "use strict";

    angular.module('app.carControllers').controller('CarViewController', CarViewController);
    
        function CarViewController($scope, $stateParams, Car) {
            
            //Get a single car.Issues a GET to /api/v1/cars/:id
            $scope.car = Car.get({id: $stateParams.id});
        }
}());
