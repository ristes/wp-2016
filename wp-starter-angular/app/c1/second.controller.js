(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('SecondController', SecondController);

  SecondController.$inject = ['$log'];

  /* @ngInject */
  function SecondController($log) {
    var vm = this;
    vm.name = 'WP';
    vm.to = 'Stojanov';
  }

})(angular);

