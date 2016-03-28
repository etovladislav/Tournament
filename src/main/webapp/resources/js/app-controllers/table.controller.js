/**
 * Created by etovladislav on 13.03.16.
 */


'use strict';

angular
    .module('appControllers')
    .controller('TableCtrl', TableCtrl);

TableCtrl.$inject = ['TournamentService', '$location', '$rootScope', '$routeParams'];
function TableCtrl(TournamentService, $location, $rootScope, $routeParams) {
    var vm = this;
    vm.tournament = null;
    vm.tId = $routeParams.tId;

    vm.tours = null;

    vm.isSchedule = false;

    vm.isTable = true;

    vm.showSchedule = function () {
        if (vm.tours == null) {
            TournamentService.GetSchedule(vm.tId).success(function (data) {
                vm.tours = data;
            })
        }
        vm.isTable = false;
        vm.isSchedule = true;

    };

    vm.showTable = function () {
        vm.isTable = true;
        vm.isSchedule = false;
    };


    TournamentService.GetTournamentById(vm.tId).success(function (data) {
        vm.tournament = data;
    })
}
