(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$log', '$resource', '$http'];

  /* @ngInject */
  function GroupServiceFn($log, $resource, $http) {

    var resource = $resource("/api/groups/:id", {}, {
      'update': {
        isArray: false,
        method: 'PUT'
      }
    });


    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };


    return service;


    function saveFn(groupEntity) {
      if (groupEntity.id) {
        return updateFn(groupEntity);
      }
      // return $http.post("/api/groups", groupEntity);
      return resource.save(groupEntity).$promise;
    }


    function updateFn(groupEntity) {

      return resource.update(
        {id: groupEntity.id},
        groupEntity,
        function (data) {
          //success
        },
        function (data) {
          //error
        }
      ).$promise;
    }

    function getByIdFn(groupId) {
      return resource.get({id: groupId}).$promise;
    }

    function getAllFn() {
      return resource.query().$promise;
    }

    function removeFn(groupEntity) {
      return resource.remove({id: groupEntity.id}).$promise;
    }


  }

})(angular);

