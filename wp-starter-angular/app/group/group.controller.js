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
    vm.entities = [];
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    vm.availableSizes = [20, 40];
    loadGroups();

    function loadGroups() {
      GroupService.getAll().then(function (data) {
        vm.entities = data;
      });
    }

    function save() {
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      var promise = GroupService.save(vm.entity);
      promise.then(successCallback, errorCallback);
      function successCallback(data) {
        loadGroups();
        vm.saveOkMsg = "Group with id " + data.id + " is saved";
        clear();
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
      GroupService
        .remove(entity)
        .then(function () {
          loadGroups();
        });
    }
  }

})(angular);

