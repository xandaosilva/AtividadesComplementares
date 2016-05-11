var cursoModule = angular.module("cursoModule",[]);

cursoModule.controller("cursoController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/curso";
	urlAdministrador = "http://localhost:8080/AtividadesComplementares/rs/administrador";
	
	$scope.novo = function(){
		$scope.curso = "";
	}
	
	$scope.seleciona = function(curso){
		$scope.curso = curso;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarAdministrador = function(){
		$http.get(urlAdministrador).success(function(administradores) {
			$scope.administradores = administradores;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.curso.codigo === ""){
			$http.post(url,$scope.curso).success(function(curso) {
				$scope.curso.push(curso);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.curso).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.pesquisarAdministrador();
	$scope.pesquisar();
});