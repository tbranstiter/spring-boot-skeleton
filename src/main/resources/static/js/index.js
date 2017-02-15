'use strict'

var index = angular.module('index', ['ngRoute']);

index.config(function($routeProvider) {
	$routeProvider
		.when("/", {
			templateUrl : "index.html"
		})
})

index.controller('home', function($scope, $http) {

		$scope.users = [ 
			{
				id: '1', 
				username: 'tbranstiter'
			}, {
				id: '2', 
				username: 'branstiterts'
			}, {
				id: '3', 
				username: 'tyler.branstiter'
			}]

	})