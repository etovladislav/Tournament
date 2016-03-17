/**
 * Created by etovladislav on 13.03.16.
 */

'use strict';

angular
    .module('appControllers')
    .controller('MyTournamentCtrl', MyTournamentCtrl);

MyTournamentCtrl.$inject = ['TournamentService', '$location'];
function MyTournamentCtrl(TournamentService, $location) {
    var vm = this;
    vm.tournaments = [];
    TournamentService.GetTournaments().success(function (data) {
        vm.tournaments = data;
    });
}