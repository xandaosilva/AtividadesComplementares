var ppcModule = angular.module("ppcModule",[]);

ppcModule.controller("ppcController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/ppc";
	
	$scope.novo = function(){
		$scope.ppc = "";
	}
	
	$scope.seleciona = function(ppc){
		$scope.ppc = ppc;
	}
	
	$scope.selecionaCurso = function(curso){
		$scope.ppc.curso = curso;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(ppcs) {
			$scope.ppcs = ppcs;
		}).error(function(erro) {
			alert(erro);
		});
	};
	
	$scope.salvar = function(){
		if($scope.ppc.codigo === ""){
			$http.post(url,$scope.ppc).success(function(ppc) {
				$scope.ppc.push(ppc);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.ppc).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	};
	
	$scope.pesquisar();
});