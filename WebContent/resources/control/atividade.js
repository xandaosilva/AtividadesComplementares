var atividadeModule = angular.module("atividadeModule",[]);

atividadeModule.controller("atividadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/atividade";
	urlModalidade = "http://localhost:8080/AtividadesComplementares/rs/modalidade";
	
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
	}
	
	$scope.pesquisarModalidade = function(){
		$http.get(urlModalidade).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.atividade.codigo == undefined){
			$http.post(url,$scope.atividade).success(function(atividade) {
				$scope.atividade.push(atividade);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$http.put(url,$scope.atividade).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.pesquisarModalidade();
	$scope.pesquisar();
});