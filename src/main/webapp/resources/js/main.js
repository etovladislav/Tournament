'use strict';
var tournamentApp = angular.module('tournamentApp', []);
var tournamentApp = angular.module('app',[]);
var tournamentApp = angular.module('appControllers', []);

var tournamentApp = angular.module('tournamentApp', [
    'ngRoute',
    'app',
    'appControllers',
]);

tournamentApp.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider
            .when('/create', {
                templateUrl: '/partials/create-tournament.html',
                controller: 'TournamentCtrl',
                controllerAs: 'vm'
            })
            .when('/tournaments', {
                templateUrl: '/partials/tournaments.html',
                controller: 'TournamentsListCtrl',
                controllerAs: 'vm'
            })
            .when('/my', {
                templateUrl: '/partials/my-tournaments.html',
                controller: 'MyTournamentCtrl',
                controllerAs: 'vm'
            })
            .when('/edit-tournament/:tournamentId', {
                templateUrl: 'partials/edit-tournament.html',
                controller: 'TournamentEditCtrl',
                controllerAs: 'vm'
            })
            .when('/table', {
                templateUrl: 'partials/table.html',
                controller: 'ournamentEditCtrl',
                controllerAs: 'vm'
            })
            .otherwise({redirectTo: '/'});
    }]);