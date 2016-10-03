var ppcModule = angular.module("ppcModule",[]);

ppcModule.controller("ppcController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/ppc";
	urlCurso = "http://localhost:8080/AtividadesComplementares/rs/curso/ativos";
	
	$scope.novo = function(){
		$scope.ppc = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(ppc){
		$scope.ppc = ppc;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(ppcs) {
			$scope.ppcs = ppcs;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar ppcs " + erro);
		});
	};
	
	$scope.pesquisarCurso = function(){
		$http.get(urlCurso).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar cursos " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.ppc.codigo === undefined || $scope.ppc.codigo === ""){
			$http.post(url,$scope.ppc).success(function(ppc) {
				$scope.ppc.push(ppc);
				$scope.novo();
				$scope.mensagens.push("Ppc cadastrado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.ppc).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Ppc atualizado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	};
	
	$scope.pesquisarCurso();
	$scope.pesquisar();
	$scope.novo();
});