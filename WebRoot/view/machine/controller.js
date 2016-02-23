
var app = angular.module('app', []);

app.controller('DemoController', function($scope) {
	
	$scope.saveMachine = function(){
		$http({
		  method: 'JSONP',
		  url: 'http://localhost:8080/fsba/view/machine/add.html'
		}).success(function(data, status, headers, config) {
		  console.log(data);
		}).error(function(data, status, headers, config) {
		});
	};

});

