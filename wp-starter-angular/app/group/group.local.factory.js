(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$log'];

  /* @ngInject */
  function GroupServiceFn($log) {
    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };


    return service;


    function saveFn(groupEntity) {
      $log.debug('saving', groupEntity);
    }

    function updateFn(groupEntity) {
      $log.debug('saving', groupEntity);
    }

    function getByIdFn(groupId) {
      $log.debug('saving', groupId);
    }

    function getAllFn() {
      $log.debug('getAll');
    }

    function removeFn(groupEntity) {
      $log.debug('remove', groupEntity);
    }

  }

})(angular);

