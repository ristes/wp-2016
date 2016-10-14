(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$log', '$timeout', '$q'];

  /* @ngInject */
  function GroupServiceFn($log, $timeout, $q) {
    var groupsList = [];
    var groupIdSequence = 0;

    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };


    return service;


    function saveFn(groupEntity) {
      var entityForSave, invalidMessage;
      var deferred = $q.defer();

      $timeout(function () {
        if (groupEntity.id === undefined) {
          entityForSave = angular.copy(groupEntity);
          invalidMessage = validateGroup(entityForSave);
          if (invalidMessage === null) {
            entityForSave.id = ++groupIdSequence;
            groupsList.push(entityForSave);
            $log.debug('saving', entityForSave);
            deferred.resolve(entityForSave);
          } else {
            $log.debug('saving invalid:', invalidMessage);
            deferred.reject({
              message: invalidMessage
            });
          }

        } else {
          updateFn(groupEntity);
        }

      }, 100);
      $log.debug('in save fn');
      return deferred.promise;
    }

    function validateGroup(entity) {
      if (entity.name === null
        || entity.name === undefined
        || typeof entity.name !== 'string'
        || entity.name.length === 0) {
        return 'Invalid name for group';
      }
      return null;
    }

    function updateFn(groupEntity) {
      if (groupEntity.id === undefined) {
        saveFn(groupEntity);
      } else {
        var savedEntity = getByIdFn(groupEntity.id);
        angular.extend(savedEntity, groupEntity);
        $log.debug("merged entity", savedEntity);
        $log.debug('updating', savedEntity);
      }

    }

    function getByIdFn(groupId) {
      var index;

      $log.debug('get by id: ', groupId);
      index = findIndexById(groupId);
      if (index === -1) {
        return null;
      } else {
        return groupsList[index];
      }

      // angular.forEach(groupsList, function(item) {
      //   result= item;
      // });
      // return result;
    }

    function getAllFn() {
      $log.debug('getAll');
      return angular.copy(groupsList);
    }

    function removeFn(groupEntity) {
      var index = findIndexById(groupEntity.id);
      if (index !== -1) {
        groupsList.splice(index, 1);
      }
      $log.debug('remove', groupEntity);
    }

    function findIndexById(groupId) {
      var result = -1, item;

      $log.debug('get index by id: ', groupId);
      for (var i = 0; i < groupsList.length; i++) {
        item = groupsList[i];
        if (item.id === groupId) {
          result = i;
          break;
        }
      }
      return result;
    }

  }

})(angular);

