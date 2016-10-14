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
    vm.edit = edit;
    vm.remove = remove;
    vm.entity = {};
    vm.entities = GroupService.getAll();
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    vm.availableSizes = [
      {
        value: 20
      }, {
        value: 40
      }
    ];

    function save() {
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      var promise = GroupService.save(vm.entity);
      promise.then(successCallback, errorCallback);
      function successCallback(data) {
        vm.entities = GroupService.getAll();
        vm.saveOkMsg = "Group with id " + data.id + " is saved";
      }

      function errorCallback(data) {
        vm.saveErrMsg = "Saving error occurred: " + data.message;
      }
    }

    function clear() {
      vm.entity = {};
    }

    function edit(entity) {
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      GroupService.remove(entity);
    }
  }

})(angular);

