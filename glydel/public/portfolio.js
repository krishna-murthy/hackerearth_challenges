'use strict';

angular.module('glydel-portfolio', [
])
.config(['$interpolateProvider', function ($interpolateProvider) {
    $interpolateProvider.startSymbol('<[');
    $interpolateProvider.endSymbol(']>');
}])
.controller('PortfolioCtrl', [
	'$scope', '$http',
  function ($scope, $http) {
      $scope.info = {};
      $scope.pageHeader = 'myStay - Simplified Hotel Browsing';
      $scope.pageTagline = 'like, save and share!';
      $scope.apiHit = 2213;
      $scope.index = 0;
      $http.get('/list_hotels')
      .success(function(data, status) {
        $scope.info = data;
        $scope.hotelCount = data.length;
        $scope.current = data[$scope.index];
        convertToBoolean($scope.current);
        getRange();
        $scope.downloadUrl = '/download/' + $scope.index;
      })
      .error(function(data, status) {
        $scope.errMessage = 'Could not get info';
      });
      $http.get('/api_hits')
      .success(function(data, status) {
          $scope.apiHits = data.api_hits;
      })
      .error(function(data, status) {
          $scope.apiHit = 'N/A';
      });
      $scope.downloadFile = function() {
          $http.get($scope.downloadUrl)
          .success(function(data, status) {
            console.log(data);
          })
          .error(function(data, status) {
              console.log(data);
          });
      };
      $scope.increaseIndex = function() {
          if ($scope.index < ($scope.info.length-1)) {
              $scope.index += 1;
              $scope.current = $scope.info[$scope.index];
              convertToBoolean($scope.current);
              getRange();
              $scope.downloadUrl = '/download/' + $scope.index;
          }
      };
      $scope.decreaseIndex = function() {
          if ($scope.index > 0) {
              $scope.index -= 1;
              $scope.current = $scope.info[$scope.index];
              convertToBoolean($scope.current);
              getRange();
              $scope.downloadUrl = '/download/' + $scope.index;
          }
      };
      var convertToBoolean = function(data) {
        data.ac = (data.ac == 1) ? 'Yes' : 'No';
        data.gym = (data.gym == 1) ? 'Yes' : 'No';
        data.pool = (data.pool == 1) ? 'Yes' : 'No';
        data.wifi = (data.wifi == 1) ? 'Available' : 'Not Available';
      };
      var getRange = function() {
        if ( $scope.index > 0) {
            $scope.previous_show = true;
            $scope.previous_index = $scope.index-1;
            $scope.previous = $scope.info[$scope.previous_index];
        }
        else {
            $scope.previous_show = false;
            $scope.previous = {};
        }
        if ( $scope.index < ($scope.info.length-1)) {
            $scope.next_show = true;
            $scope.next_index = $scope.index+1;
            $scope.next = $scope.info[$scope.next_index];
        }
        else {
            $scope.next_show = false;
            $scope.next = {};
        }
      };
  }
]);

