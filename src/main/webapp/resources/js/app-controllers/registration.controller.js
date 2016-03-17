/**
 * Created by etovladislav on 10.03.16.
 */
    'use strict';

    angular
        .module('appControllers')
        .controller('RegisterCtrl', RegisterCtrl);

    RegisterCtrl.$inject = ['UserService', '$location', '$rootScope'];
    function RegisterCtrl(UserService, $location, $rootScope) {
        var vm = this;

        vm.register = register;

        function register() {
            vm.dataLoading = true;
            vm.isError = false;
            UserService.Create(vm.user).success(function(data) {
                $location.path("/login")
            }).error(function(data) {
                vm.error = "Введите другой email адрес";
                vm.isError = true;
                vm.dataLoading = false;
            })

        }
    }
