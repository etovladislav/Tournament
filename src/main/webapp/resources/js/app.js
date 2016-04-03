'use strict';
var tournamentApp = angular.module('tournamentApp', []);
var tournamentApp = angular.module('app',[]);
var tournamentApp = angular.module('appControllers',[]);

var tournamentApp = angular.module('tournamentApp', [
    'ngRoute',
    'app',
    'appControllers',
]);

tournamentApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/registration', {
                templateUrl: '/partials/registration.html',
                controller: 'RegisterCtrl',
                controllerAs: 'vm'
            })
            .when('/login', {
                templateUrl: 'partials/login.html',
                controller: 'LoginCtrl',
                controllerAs: 'vm'
            })
            .when('/', {
                templateUrl: 'partials/start-page.html',
                controller: 'StartPageCtrl',
            })
            .otherwise({redirectTo: '/'});
    }]);