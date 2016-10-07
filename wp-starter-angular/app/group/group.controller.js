(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('GroupController', GroupController);

  GroupController.$inject = ['$log', 'GroupService'];

  /* @ngInject */
  function GroupController($log, GroupService) {
    var vm = this;
    vm.title = 'Group';
    vm.save = save;
    vm.clear = clear;
    vm.entity = {};

    function save() {
      GroupService.save(vm.entity);
    }

    function clear() {
      vm.entity = {};
    }
  }

})(angular);

