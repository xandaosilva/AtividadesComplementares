var modalidadeModule = angular.module("modalidadeModule",[]);

modalidadeModule.controller("modalidadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/modalidade";
	
	$scope.novo = function(){
		$scope.modalidade = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(modalidade){
		$scope.modalidade = modalidade;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar modalidades " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.modalidade.codigo === undefined || $scope.modalidade.codigo === ""){
			$http.post(url,$scope.modalidade).success(function(modalidade) {
				$scope.modalidade.push(modalidade);
				$scope.mensagens.push("Modalidade cadastrada com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.modalidade).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Modalidade atualizada com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}

	$scope.pesquisar();
	$scope.novo();
});