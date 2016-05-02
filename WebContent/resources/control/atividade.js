var atividadeModule = angular.module("atividadeModule",[]);

atividadeModule.controller("atividadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/atividade";
	urlAluno = "http://localhost:8080/AtividadesComplementares/rs/aluno";
	urlAdministrador = "http://localhost:8080/AtividadesComplementares/rs/administrador";
	urlCategoria = "http://localhost:8080/AtividadesComplementares/rs/categoria";
	
	$scope.novo = function(){
		$scope.atividade = "";
	}
	
	$scope.seleciona = function(atividade){
		$scope.atividade = atividade;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			alert(erro);
		});
	};
	
	$scope.pesquisarAluno = function(){
		$http.get(urlAluno).success(function(alunos) {
			$scope.alunos = alunos;
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
	
	$scope.pesquisarCategoria = function(){
		$http.get(urlCategoria).success(function(categorias) {
			$scope.categorias = categorias;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.atividade.codigo === ""){
			$http.post(url,$scope.atividade).success(function(atividade) {
				$scope.atividade.push(atividade);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.atividade).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	};
	
	$scope.pesquisarAluno();
	$scope.pesquisarAdministrador();
	$scope.pesquisarCategoria();
	$scope.pesquisar();
});