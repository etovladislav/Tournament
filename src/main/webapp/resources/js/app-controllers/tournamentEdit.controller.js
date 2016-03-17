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
    vm.isEditing = false;
    vm.teamName = null;
    vm.tournamentId = $routeParams.tournamentId;

    function addTeam() {
        TournamentService.addTeam(vm.teamName, vm.tournamentId).success(function(data){
            vm.tournament.teams.push(data);
        })
    }
    TournamentService.GetTournamentById(vm.tournamentId).success(function(data) {
        vm.tournament = data;
    })

}
