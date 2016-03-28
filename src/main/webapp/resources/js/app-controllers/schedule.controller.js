/**
 * Created by etovladislav on 10.03.16.
 */
'use strict';

angular
    .module('appControllers')
    .controller('ScheduleCtrl', ScheduleCtrl);

ScheduleCtrl.$inject = ['TournamentService', '$location', '$rootScope', '$routeParams'];
function ScheduleCtrl(TournamentService, $location, $rootScope, $routeParams) {

    var vm = this;

    vm.tId = $routeParams.tId;

    vm.schedule = null;


    TournamentService.GetSchedule(vm.tId).success(function (data) {
        vm.schedule = data;
    })
}
