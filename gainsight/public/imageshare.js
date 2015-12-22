'use strict';

angular.module('gainsight-imaging', ['ui.bootstrap', "chart.js", 'infinite-scroll', 'djds4rce.angular-socialshare', 'ngProgress'])
.config(['$interpolateProvider', function ($interpolateProvider) {
    $interpolateProvider.startSymbol('<[');
    $interpolateProvider.endSymbol(']>');
}])
.config(['$locationProvider', function($locationProvider){
        $locationProvider.html5Mode(true).hashPrefix('!');
}])
.controller('ImagingCtrl', [
    '$scope', '$http', '$modal', 'ngProgressFactory',
    function ($scope, $http, $modal, ngProgressFactory) {
    
    $scope.info = {};
    $scope.pageHeader = 'Gainsight Image Looper!';
    $scope.pageTagline = 'infinite scroll; social sharing!';
    $scope.totalLikes = 0;
    $scope.pageNumber = 0;
    $scope.infiniteScroll = 0;
    $scope.next_show = true;
    
    $scope.checkPrevious = function() {
        if ($scope.pageNumber > 0 ) {
            $scope.previous_show = true;
        }
        else {
            $scope.previous_show = false;
        }
    };
    $scope.checkPrevious();

    $scope.reloadLikes = function() {
        $http.get('/total_likes')
        .success(function(data, status) {
            $scope.totalLikes = data.total_likes;
        })
        .error(function(data, status) {
            $scope.totalLikes = 'N/A';
        });
    }
    $scope.reloadLikes();

    $scope.getImages = function(infiniteScroll) {
        var imageUrl = '/image_list/' + $scope.pageNumber;
        $http.get(imageUrl) 
        .success(function(data, status) {
            if (!infiniteScroll)
                $scope.imageList = [];
            $scope.firstRow = [];
            $scope.secondRow = [];
            $scope.thirdRow = [];
            for ( var i = 0; i < data.length; i++) {
                if (i < 3) {
                    $scope.firstRow.push(data[i]);
                }
                if (i > 2 && i < 6) {
                    $scope.secondRow.push(data[i]);
                }
                if ( i > 5) {
                    $scope.thirdRow.push(data[i]);
                }
            }
            $scope.imageList.push($scope.firstRow);
            $scope.imageList.push($scope.secondRow);
            $scope.imageList.push($scope.thirdRow);
        })
        .error(function(data, status) {
            $scope.imageList = {};
        });
    }
    $scope.getImages(false);

    $scope.likeImage = function(img) {
        $http.post('/like_image', img)
        .success(function(data, status) {
            $scope.reloadLikes();
        })
        .error(function(data, status) {
        });
    };

    $scope.increaseIndex = function() {
        $scope.pageNumber += 1;
        $scope.getImages(false);
        $scope.checkPrevious();
    };

    $scope.decreaseIndex = function() {
        $scope.pageNumber -= 1;
        $scope.getImages(false);
        $scope.checkPrevious();
    };

    $scope.open = function(img) {
        var modalInstance = $modal.open({
            templateUrl: 'myModalContent.html',
            controller: 'ModalInstanceCtrl',
            resolve: {
                image: function() {
                    return img;
                }    
            }
        });
    };

    $scope.toggleInfinite = false;
    $scope.$watch('infiniteScroll', function() {
        if($scope.infiniteScroll) {
            console.log($scope.infiniteScroll);
            $scope.toggleInfinite = true;
            $scope.selectedTemplate = 'withScroll.html';
        }
        else {
            $scope.toggleInfinite = false;
            $scope.selectedTemplate = 'withoutScroll.html';
        }
    });

    $scope.myPagingFunction = function() {
        $scope.pageNumber += 1;
        $scope.getImages(true);
    };

    $scope.loadedImages = 0;
    $scope.progressbar = ngProgressFactory.createInstance();
    $scope.progressbar.start();
    $scope.$watch('loadedImages', function() {
        if ( $scope.loadedImages == 9 ) {
            $scope.progressbar.complete();
        }
    });
}])
.controller('ModalInstanceCtrl', function ($scope, $modalInstance, image) {
    $scope.image = image;
    console.log($scope.image.demographic);
    $scope.labels = ["China", "India", "USA"];
    $scope.data = [$scope.image.demographic.China, $scope.image.demographic.India, $scope.image.demographic.USA];
    $scope.ok = function () {
        $modalInstance.close();
    };    
})
.directive('imageonload', function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.bind('load', function() {
                scope.loadedImages += 1;
            });
        }
    };
});

