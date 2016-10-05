var atividadeModule = angular.module("atividadeModule",[]);

atividadeModule.controller("atividadeController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/atividade";
	urlModalidade = "http://localhost:8080/AtividadesComplementares/rs/modalidade/ativas";
	
	$scope.novo = function(){
		$scope.atividade = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

	$scope.seleciona = function(atividade){
		$scope.atividade = atividade;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar atividades " + erro);
		});
	}
	
	$scope.pesquisarModalidade = function(){
		$http.get(urlModalidade).success(function(modalidades) {
			$scope.modalidades = modalidades;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar modalidades " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.atividade.codigo === undefined || $scope.atividade.codigo === ""){
			$http.post(url,$scope.atividade).success(function(atividade) {
				$scope.atividades.push(atividade);
				$scope.novo();
				$scope.mensagens.push("Atividade salva com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.atividade).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Atividade atualizada com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.pesquisarModalidade();
	$scope.pesquisar();
	$scope.novo();
});