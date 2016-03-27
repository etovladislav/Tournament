/**
 * Created by etovladislav on 13.03.16.
 */



'use strict';

angular
    .module('appControllers')
    .controller('TournamentCtrl', TournamentCtrl);

TournamentCtrl.$inject = ['TournamentService', '$location', '$rootScope'];
function TournamentCtrl(TournamentService, $location, $rootScope) {
    var vm = this;
    vm.error = false;
    vm.createTournament = createTournament;


    function createTournament() {
        TournamentService.Create(vm.tournament).success(function(data) {
            $location.path('/my');
        }).error(function(data) {
            vm.error = true;
        })

    }
}