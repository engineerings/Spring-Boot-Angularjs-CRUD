(function () {
    "use strict";

    angular.module('app.services', []).factory('Car', Car).service('popupService', popupService);

    function Car($resource) {
        return $resource('/api/v1/cars/:id', { id: '@id' }, {
            update: {
                method: 'PUT'
            }
        });
    }

    function popupService($window){
        this.showPopup=function(message){
            return $window.confirm(message);
        }
    }
}());
