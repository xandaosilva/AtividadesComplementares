var turmaModule = angular.module("turmaModule",[]);

turmaModule.controller("turmaController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/turma";
	urlPpc = "http://localhost:8080/AtividadesComplementares/rs/ppc";
	
	$scope.novo = function(){
		$scope.turma = "";
	}
	
	$scope.seleciona = function(turma){
		$scope.turma = turma;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(turmas) {
			$scope.turmas = turmas;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.pesquisarPpc = function(){
		$http.get(urlPpc).success(function(ppcs) {
			$scope.ppcs = ppcs;
		}).error(function(erro) {
			alert(erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.turma.codigo === ""){
			$http.post(url,$scope.turma).success(function(turma) {
				$scope.turma.push(turma);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.turma).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	};
	
	$scope.pesquisarPpc();
	$scope.pesquisar();
});