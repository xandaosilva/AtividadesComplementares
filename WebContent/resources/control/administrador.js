var administradorModule = angular.module("administradorModule",[]);

administradorModule.controller("administradorController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/administrador";
	urlAtividade = "http://localhost:8080/AtividadesComplementares/rs/atividade";
	
	$scope.novo = function(){
		$scope.administrador = "";
	}
	
	$scope.seleciona = function(administrador){
		$scope.administrador = administrador;
	}

	$scope.pesquisar = function(){
		$http.get(url).success(function(administradores) {
			$scope.administradores = administradores;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarAtividade = function(){
		$http.get(urlAtividade).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.administrador.codigo === ""){
			$http.post(url,$scope.administrador).success(function(administrador) {
				$scope.administrador.push(administrador);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.administrador).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar();
});