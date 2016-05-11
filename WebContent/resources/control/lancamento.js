var lancamentoModule = angular.module("lancamentoModule",[]);

lancamentoModule.controller("lancamentoController", function($scope,$http) {
	url = "http://localhost:8080/lancamentosComplementares/rs/lancamento";
	urlAluno = "http://localhost:8080/lancamentosComplementares/rs/aluno";
	urlAdministrador = "http://localhost:8080/lancamentosComplementares/rs/administrador";
	urlAtividade = "http://localhost:8080/lancamentosComplementares/rs/atividade";
	
	$scope.novo = function(){
		$scope.lancamento = "";
	}
	
	$scope.seleciona = function(lancamento){
		$scope.lancamento = lancamento;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(lancamentos) {
			$scope.lancamentos = lancamentos;
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
	
	$scope.pesquisarAtividade = function(){
		$http.get(urlatividade).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.lancamento.codigo == undefined){
			$http.post(url,$scope.lancamento).success(function(lancamento) {
				$scope.lancamento.push(lancamento);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$http.put(url,$scope.lancamento).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	};
	
	$scope.pesquisarAluno();
	$scope.pesquisarAdministrador();
	$scope.pesquisarAtividade();
	$scope.pesquisar();
});