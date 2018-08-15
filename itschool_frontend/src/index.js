var env = {};
if(window){
  Object.assign(env, window.__env);
}

var app = angular.module('courses', ['angular.filter', 'ngRoute']);
app.constant('__env', env);

app.controller('coursesController', function($scope, $http, __env){
        $http.get(__env.apiUrl + '/courses').
        then(function(response){
          console.log("loool");
          console.log(response.data);
          $scope.courseList = response.data;
        });
});

app.controller('authenticationController', function($scope, $http, __env, $rootScope, $location){
        console.log("begining");
        $scope.error = false;
        console.log($scope.error);
        var authentication = function(callback){
          console.log("in");
          console.log($scope.credentials.username);
            var headers = $scope.credentials ? {authorization : "Basic "
            + btoa($scope.credentials.username + ":" + $scope.credentials.password)} : {};
            console.log("in22");
            console.log($scope.credentials.username);
            $http.get(__env.apiUrl + '/user').
            then(function(response){
              console.log("loool");
              console.log(response.data);
              if(response.name){
                $rootScope.authenticated = true;
              }
              else{
                $rootScope.authenticated = false;
              }
            callback && callback();
          },
            function error(response) {
              console.log("Error in GET");
              $rootScope.authenticated = false;
              callback && callback();
            });
        }
        // authentication();
        $scope.credentials = {};

        $scope.login = function(){
          console.log("log in is called");
          authentication(function(){
            if($rootScope.authenticated){
              $scope.error = false;
              $location.path('/home');
            }
            else{
              $scope.error = true;
              $location.path('/login');
            }
          })
        }

        $scope.logout = function() {
          console.log('in logout');
          $http.post('logout', {}).success(function() {
            $rootScope.authenticated = false;
            $location.path("/");
          }).error(function(data) {
            $rootScope.authenticated = false;
          });
        }


});



app.config(function($routeProvider) {
  $routeProvider
  .when('/', {
    templateUrl : 'pages/home.html',
    // controller  : 'HomeController'
  })

  .when('/courses', {
    templateUrl : 'pages/courses.html',
    // controller  : 'BlogController'
  })

  .when('/rules', {
    templateUrl : 'pages/rules.html',
    // controller  : 'AboutController'
  })

  .when('/contacts', {
    templateUrl : 'pages/contacts.html',
    // controller  : 'AboutController'
  })

  .when('/login', {
    templateUrl : 'pages/login.html',
    // controller  : 'AboutController'
  })

  .otherwise({redirectTo: '/'});
});
