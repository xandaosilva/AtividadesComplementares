var modalidadeModule = angular.module("modalidadeModule",[]);

modalidadeModule.controller("modalidadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/modalidade";
	
	$scope.novo = function(){
		$scope.modalidade = "";
	}
	
	$scope.seleciona = function(modalidade){
		$scope.modalidade = modalidade;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.modalidade.codigo === ""){
			$http.post(url,$scope.modalidade).success(function(modalidade) {
				$scope.modalidade.push(modalidade);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.modalidade).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	}
	
	$scope.pesquisar();
});