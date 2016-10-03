var turmaModule = angular.module("turmaModule",[]);

turmaModule.controller("turmaController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/turma";
	urlPpc = "http://localhost:8080/AtividadesComplementares/rs/ppc/ativos";
	
	$scope.novo = function(){
		$scope.turma = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(turma){
		$scope.turma = turma;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(turmas) {
			$scope.turmas = turmas;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar turmas " + erro);
		});
	}
	
	$scope.pesquisarPpc = function(){
		$http.get(urlPpc).success(function(ppcs) {
			$scope.ppcs = ppcs;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar ppcs " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.turma.codigo === undefined || $scope.turma.codigo === ""){
			$http.post(url,$scope.turma).success(function(turma) {
				$scope.turma.push(turma);
				$scope.novo();
				$scope.mensagens.push("Turma cadastrada com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.turma).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Turma atualizada com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	};
	
	$scope.pesquisarPpc();
	$scope.pesquisar();
	$scope.novo();
});