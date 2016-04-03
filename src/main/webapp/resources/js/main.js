'use strict';
var tournamentApp = angular.module('tournamentApp', []);
var tournamentApp = angular.module('app', []);
var tournamentApp = angular.module('appControllers', ['ui.bootstrap']);
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
            .when('/', {
                templateUrl: '/partials/my-tournaments.html',
                controller: 'MyTournamentCtrl',
                controllerAs: 'vm'
            })
            .when('/edit-tournament/:tournamentId', {
                templateUrl: 'partials/edit-tournament.html',
                controller: 'TournamentEditCtrl',
                controllerAs: 'vm'
            })
            .when('/tournament/:tId', {
                templateUrl: 'partials/table.html',
                controller: 'TableCtrl',
                controllerAs: 'vm'
            })
            .when('/schedule/:tId', {
                templateUrl: 'partials/schedule.html',
                controller: 'ScheduleCtrl',
                controllerAs: 'vm'
            })
            .when('/results/:tId', {
                templateUrl: 'partials/results.html',
                controller: 'ResultsCtrl',
                controllerAs: 'vm'
            })
            .otherwise({redirectTo: '/'});
    }]);