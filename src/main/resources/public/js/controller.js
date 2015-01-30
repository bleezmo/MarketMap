var app = angular.module("PhoneCatApp",["ngRoute"]);

app.config(["$routeProvider",function($routeProvider){
	$routeProvider.when("/phones",{
		templateUrl: "/partials/phone-list.html",
		controller: "PhoneListCtrl"
	}).when("/phones/:phoneId",{
		templateUrl: "/partials/phone-detail.html",
		controller: "PhoneDetailCtrl"
	}).otherwise({
		redirectTo: "/phones"
	});
}]);

app.controller("PhoneListCtrl",["$scope","$http",function($scope,$http){
    $scope.orderProp = 'age';
    $scope.phones = [];
    $http.get("/phones.json").success(function(data){
    	$scope.phones = data;
    });
}]);

app.controller("PhoneDetailCtrl",["$scope","$routeParams","$http",
	function($scope,$routeParams,$http){
	$http.get($routeParams.phoneId+".json").success(function(data){
		$scope.phone = data;
		$scope.mainImageUrl = data.images[0];
	});
	$scope.setImage = function(img){
		$scope.mainImageUrl = img;
	}
}]);