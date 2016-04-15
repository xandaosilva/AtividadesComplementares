var atividadeModule = angular.module("atividadeModule",[]);

atividadeModule.controller("atividadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/atividade";
	
	$scope.novo = function(){
		$scope.atividade = "";
	}
	
	$scope.seleciona = function(atividade){
		$scope.atividade = atividade;
	}
	
	$scope.selecionaAluno = function(aluno) {
		$scope.atividade.aluno = aluno;
	}
	
	$scope.selecionaAdministrador = function(administrador){
		$scope.atividade.administrador = administrador;
	}
	
	$scope.selecionaCategoria = function(categoria){
		$scope.atividade.categoria = categoria;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			alert(erro);
		});
	};
	
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
	
	$scope.pesquisar();
});