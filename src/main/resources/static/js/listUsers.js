//'use strict';
//
//app.controller('ListUsersController', ['$scope', '$http', function($scope, $http) {
//	
//	$scope.users = []	
//	
//	(function getUsers() {
//		$http.get('/api/users').success(function(data) {
//			angular.forEach(data, function(user) {
//				console.log(user)
//				$scope.users.push(user);
//			})
//		})
//	})()
//	
//}])