/**
 * Created by etovladislav on 13.03.16.
 */


'use strict';

angular
    .module('appControllers')
    .controller('TournamentEditCtrl', TournamentEditCtrl);

TournamentEditCtrl.$inject = ['TournamentService', '$location', '$rootScope', '$routeParams'];
function TournamentEditCtrl(TournamentService, $location, $rootScope, $routeParams) {
    var vm = this;
    vm.tournament = null;
    vm.teamName = null;
    vm.tournamentId = $routeParams.tournamentId;
    vm.team = {};

   vm.addTeam = function() {
        vm.team.name = vm.teamName;
        vm.team.tournamentId = vm.tournamentId;
        TournamentService.addTeam(vm.team).success(function(data){
            vm.tournament.teams.push(data);
            vm.team = {};
            vm.teamName = null;
        })
    }
    TournamentService.GetTournamentById(vm.tournamentId).success(function(data) {
        vm.tournament = data;
    })

}
