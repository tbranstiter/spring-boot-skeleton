'use strict';

var app = angular.module('app', ['ngRoute']);

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
		.when('/editUser', {
			templateUrl: 'views/editUser.html',
			controller: 'EditUserController' 
		})
		.otherwise({ redirectTo: '/' });
	
}]);

app.controller('HomeController', ['$scope', '$http', function($scope, $http) {
	
	
	
}]);

app.controller('ListUsersController', ['$scope', '$http', 'redirectService', function($scope, $http, redirectService) {
		
	$scope.users = [];
	
	(function getUsers() {
		$http.get('/api/users').success(function(data) {
			angular.forEach(data, function(user) {
				console.log(user)
				$scope.users.push(user);
			})
		})
	})()
	
	$scope.redirectHome = function() {
		redirectService.redirectHome();
	}
	
}]);

app.controller('AddUserController', ['$scope', '$http', 'redirectService', function($scope, $http, redirectService) {
	
	$scope.message = "";
	
	$scope.user = {
			"username" : "",
			"password" : "",
			"confirmPassword" : ""
	};
		
	$scope.submitForm = function(isValid) {
		if(isValid) {
			console.log($scope.user)			
			
			$http({
				method: 'POST',
				url: '/api/users',
				data: $scope.user,
				headers: {
					'Content-type': 'application/json'
				}
			})
			.success(function (response) {
				console.log(response);
				    // not relevant
			})
			.error(function (error) {
				console.log(error);
			    // not relevant
			});
		} else {
			$scope.message = "There are still invalid fields below!";
		}
	};
	
	$scope.redirectHome = function() {
		redirectService.redirectHome();
	}
	
}]);

app.controller('EditUserController', ['$scope', '$http', 'redirectService', function($scope, $http, redirectService) {
	
	$scope.submitForm = function(isValid) {
		if(isValid) {
			console.log($scope.user)			
			
		} else {
			$scope.message = "There are still invalid fields below!";
		}
	};
	
	$scope.redirectHome = function() {
		redirectService.redirectHome();
	}
	
}]);





app.factory('redirectService', function($location) {
	return {
		redirectHome: function() {
			$location.path("#/");
		}
	};
});



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