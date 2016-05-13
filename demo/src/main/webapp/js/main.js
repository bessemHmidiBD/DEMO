angular.module("demo", []).run(function($rootScope) {

	$rootScope.title = "demo application";

}).controller("TodosCtrl", function($scope,$log,todosService) {

	$log.debug("here");
	$scope.allTodos = [];

	todosService.getAll().then(function successCallback(response) {
		$scope.allTodos = response.data;
		//if (!$scope.$$phase) $scope.$apply();
	}, function errorCallback(response) {
		// called asynchronously if an error occurs
		// or server returns response with an error status.
	});

	$scope.add=function(todos){
		
		todosService.add(todos).success(function(data){
			$scope.allTodos.push(todos);
		});	
	};
	
})
.factory("todosService",function($http){
	
	var service={
			
			getAll:function(){
				return $http({
					method : 'GET',
					url : 'rest/TODOS'
				});
			},
			add:function(todos){
				return $http({
					method : 'PUT',
					url : 'rest/TODOS',
					data:todos
				});
			}
			
			
	};
	
	
	
	return service;
	
})