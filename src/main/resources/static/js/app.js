'use strict';

var app = angular.module('app', ['ngRoute','ngResource']);

app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl: 'views/home.html',
			controller: 'HomeController'
		})
		.when('/listUsers', {
			templateUrl: 'views/listUsers.html',
			controller: 'ListUsersController' 
		})
		.when('/addUser', {
			templateUrl: 'views/addUser.html',
			controller: 'AddUserController' 
		})
		.otherwise({ redirectTo: '/' });
	
}]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
	
	
	
}]);

app.controller('ListUsersController', ['$scope', '$http', function($scope, $http) {
		
	$scope.users = [];
	
	(function getUsers() {
		$http.get('/api/users').success(function(data) {
			angular.forEach(data, function(user) {
				console.log(user)
				$scope.users.push(user);
			})
		})
	})()
	
}]);

app.controller('AddUserController', ['$scope', '$http', function($scope, $http) {
	
	$scope.message = "";
	
	$scope.user = "";
	
	$scope.submitForm = function(isValid) {
		if(isValid) {
			console.log($scope.user)			
			$http.post('/api/users', $scope.user)
				.success(function(data) {
					console.log(data);
				})
				.error(function(data) {
					alert("Failure Message: " + JSON.stringify({data: data}));
				}); 
		} else {
			$scope.message = "There are still invalid fields below!";
		}
	};
	
}]);





var compareTo = function() {
    return {
        require: "ngModel",
        scope: {
            otherModelValue: "=compareTo"
        },
        link: function(scope, element, attributes, ngModel) {
             
            ngModel.$validators.compareTo = function(modelValue) {
                return modelValue == scope.otherModelValue;
            };
 
            scope.$watch("otherModelValue", function() {
                ngModel.$validate();
            });
        }
    };
};

app.directive("compareTo", compareTo);