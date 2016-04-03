/**
 * Created by etovladislav on 10.03.16.
 */
'use strict';

angular
    .module('appControllers')
    .controller('ResultsCtrl', ResultsCtrl);

ResultsCtrl.$inject = ['TournamentService','$routeParams','$uibModal'];
function ResultsCtrl(TournamentService, $routeParams, $uibModal) {

    var vm = this;
    vm.tId = $routeParams.tId;
    vm.tours = null;

    TournamentService.GetSchedule(vm.tId).success(function (data) {
        vm.tours = data;
    })

    vm.open = function (match) {
        console.log(match);
        var modalInstance = $uibModal.open({
            templateUrl: '/partials/resultMatch.html',
            controller: 'ResultMatchCtrl',
            controllerAs: 'vm',
            resolve: {
                items: function() {
                    return match;
                }
            }
        });
    }
}
