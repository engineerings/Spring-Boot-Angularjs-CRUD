(function() {
    "use strict";
    
	var app = angular.module('app', [
        'ui.router',
        'ngAnimate',
        'ui.bootstrap',
        'ngResource',
        'app.carControllers',
        'app.services'
    ]);

	define('app', [], function() {
        return app;
    });

	function req(deps) {
		if (typeof deps === 'string') deps = [deps];
		return {
			deps: function ($q, $rootScope) {
				var deferred = $q.defer();
				require(deps, function() {
					$rootScope.$apply(function () {
						deferred.resolve();
					});
					deferred.resolve();
				});
				return deferred.promise;
			}
		}
	}

	app.config(function($stateProvider, $urlRouterProvider, $controllerProvider){
		var sourceController = app.controller;
		app.controller = function (name, constructor){
			$controllerProvider.register(name, constructor);
			return sourceController.apply(this, arguments);
		};

		var viewsPrefix = 'views/';

		$stateProvider
			.state('welcome', {
				url: "/",
				templateUrl: viewsPrefix + "welcome.html"
			})
			.state('cars',{
	        url:'/cars',
	        templateUrl: viewsPrefix + 'cars.html',
	        controller:'CarListController'
	    }).state('viewCar',{
	       url:'/cars/:id/view',
	       templateUrl: viewsPrefix + 'car-view.html',
	       controller:'CarViewController'
	    }).state('newCar',{
	        url:'/cars/new',
	        templateUrl: viewsPrefix + 'car-add.html',
	        controller:'CarCreateController'
	    }).state('editCar',{
	        url:'/cars/:id/edit',
	        templateUrl: viewsPrefix + 'car-edit.html',
	        controller:'CarEditController'
	    });

		$urlRouterProvider.otherwise("/");
	});

}());
