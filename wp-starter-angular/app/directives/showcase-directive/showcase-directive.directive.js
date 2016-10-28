(function () {
  'use strict';

  angular
    .module('wp-angular-starter')
    .directive('showcaseDirective', wpNav);

  wpNav.$inject = [];

  /* @ngInject */
  function wpNav() {
    var directive = {
      restrict: 'EA',
      templateUrl: 'app/directives/showcase-directive/showcase-directive.view.html',
      scope: {
        stringConstant: '@',
        oneWayBindingVariable: '<',
        twoWayBindingVariable: '=',
        functionBinding: '&',
        functionObjectBinding: '=',
        generatedAttribute: '<'
      },
      controller: WpNavController,
      bindToController: true,
      controllerAs: 'vm',
      link: link, // since compile is defined, this will not be invoked
      compile: compileFn, // for more details see: https://docs.angularjs.org/api/ng/service/$compile
      transclude: {
        trName: '?trname',
        trValue: '?trval'
      }
    };
    return directive;

    function compileFn(element, attr,transclude) {
      console.log('in compile for element: ', element);
      console.log(transclude);
      /**
       *
       * The value of the generatedAttribute will be the value of the variable $scope.$parent.to
       */
      attr.generatedAttribute = 'to';
      return postLinkFn;
    }

    function postLinkFn(scope, element, attr) {
      console.log('in postLinkFn');

      link(scope, element, attr);
    }


    function link(scope, element, attrs) {
      console.log('in link function for element: ', element);
      angular.forEach(attrs, function (val, key) {
        console.log(key, "->", val, '<', scope.vm[key], '>');
      });
    }
  }

  WpNavController.$inject = [];

  /* @ngInject */
  function WpNavController() {
    var vm = this;

    console.log('in directive controller');

    vm.name='Petko';

    vm.invokeFunctionFromObject = invokeFunctionFromObject;

    function invokeFunctionFromObject() {
      if (typeof vm.functionObjectBinding === 'function') {
        console.log('in invokeFunctionFromObject');
        vm.functionObjectBinding();
      } else {
        console.log('no function for attribute functionObjectBinding');
      }
    }
  }


})();

