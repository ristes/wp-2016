(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);

  registerState.$inject = ['$stateProvider'];

  function registerState($stateProvider) {

    var $log = {
      debug: function (message) {
        if (console && typeof console.log === 'function') {
          console.log(message);
        }
      }
    };

    $stateProvider.state('first', {
      url: '/first',
      templateUrl: 'app/c1/first.view.html',
      controller: 'FirstController',
      controllerAs: 'vm'
    });


    $log.debug('State first initialized');

    $stateProvider.state('second', {
      url: '/second',
      templateUrl: 'app/c1/second.view.html',
      controller: 'SecondController',
      controllerAs: 'vm'
    });
    $log.debug('State second initialized');
  }

  //x.nesto -> calling 'nesto' from undefined
  // var x = function () {
  //   this.nesto = 'nest';
  // };

})(angular);
