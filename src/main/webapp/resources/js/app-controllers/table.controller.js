/**
 * Created by etovladislav on 10.03.16.
 */
'use strict';

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

    console.log($routeParams);


    TournamentService.GetTournamentById(vm.tId).success(function (data) {
        vm.tournament = data;
    })
}
