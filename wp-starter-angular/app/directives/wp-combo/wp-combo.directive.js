(function () {
  'use strict';

  angular
    .module('wp-angular-starter')
    .directive('wpCombo', wpCombo);

  wpCombo.$inject = [];

  /* @ngInject */
  function wpCombo() {
    var directive = {
      restrict: 'E',
      templateUrl: 'app/directives/wp-combo/wp-combo.view.html',
      scope: {
        wpLabel: '@',
        wpModel: '=',
        wpData: '='
      },
      controller: WpComboController,
      bindToController: true,
      controllerAs: 'vm',
      compile: compileFn, // for more details see: https://docs.angularjs.org/api/ng/service/$compile
      transclude: {
        item: 'item',
        selected: 'selected'
      }
    };
    return directive;

    function compileFn(element, attr, transclude) {
      return postLinkFn;
    }

    function postLinkFn(scope, element, attr) {

    }

  }

  WpComboController.$inject = [];

  /* @ngInject */
  function WpComboController() {
    var vm = this;

    vm.placeholder = 'Choose ' + vm.wpLabel;

  }


})();

