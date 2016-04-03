/**
 * Created by etovladislav on 10.03.16.
 */
'use strict';

angular
    .module('appControllers')
    .controller('ResultMatchCtrl', ResultMatchCtrl);

ResultMatchCtrl.$inject = ['TournamentService', '$rootScope', '$uibModalInstance', 'items'];
function ResultMatchCtrl(TournamentService, $rootScope, $uibModalInstance, items) {
    var vm = this;
    vm.match = items;

    vm.ok = function () {
        TournamentService.saveMatch(vm.match).success(function() {
            $uibModalInstance.close();
        })
    };

    vm.cancel = function () {
        $uibModalInstance.dismiss();
    };
}
