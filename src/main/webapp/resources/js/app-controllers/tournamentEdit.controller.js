/**
 * Created by etovladislav on 13.03.16.
 */


'use strict';

angular
    .module('appControllers')
    .controller('TournamentEditCtrl', TournamentEditCtrl);

TournamentEditCtrl.$inject = ['TournamentService', '$location', '$rootScope', '$routeParams', '$uibModal'];
function TournamentEditCtrl(TournamentService, $location, $rootScope, $routeParams) {
    var vm = this;
    vm.tournament = null;
    vm.teamName = null;
    vm.tournamentId = $routeParams.tournamentId;
    vm.team = {};

    TournamentService.GetTournamentById(vm.tournamentId).success(function (data) {
        vm.tournament = data;
    })



    vm.addTeam = function () {
        vm.team.name = vm.teamName;
        vm.team.tournamentId = vm.tournamentId;
        TournamentService.addTeam(vm.team).success(function (data) {
            vm.tournament.teams.push(data);
            vm.team = {};
            vm.teamName = null;
        })
    }

    vm.generateSchedule = function (id) {
        TournamentService.generateSchedule(id).success(function () {

        })
    };

    vm.selected = {};
    vm.getTemplate = function (team) {
        if (team.id === vm.selected.id) return 'edit';
        else return 'display';
    };

    vm.editTeam = function (contact) {
        vm.selected = angular.copy(contact);
    };

    vm.saveTeam = function (idx) {
        TournamentService.editTeam(vm.selected).success(function () {
            vm.tournament.teams[idx] = angular.copy(vm.selected);
            vm.reset();
        });
    };

    vm.reset = function () {
        vm.selected = {};
    };
}