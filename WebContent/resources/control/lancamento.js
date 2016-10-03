var lancamentoModule = angular.module("lancamentoModule",[]);

lancamentoModule.controller("lancamentoController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/lancamento";
	urlAluno = "http://localhost:8080/AtividadesComplementares/rs/aluno/ativos";
	urlAdministrador = "http://localhost:8080/AtividadesComplementares/rs/administrador/ativos";
	urlAtividade = "http://localhost:8080/AtividadesComplementares/rs/atividade/ativas";
	
	$scope.novo = function(){
		$scope.lancamento = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(lancamento){
		$scope.lancamento = lancamento;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(lancamentos) {
			$scope.lancamentos = lancamentos;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar lancamentos " + erro);
		});
	};
	
	$scope.pesquisarAluno = function(){
		$http.get(urlAluno).success(function(alunos) {
			$scope.alunos = alunos;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar alunos " + erro);
		});
	}
	
	$scope.pesquisarAdministrador = function(){
		$http.get(urlAdministrador).success(function(administradores) {
			$scope.administradores = administradores;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar administradores " + erro);
		});
	}
	
	$scope.pesquisarAtividade = function(){
		$http.get(urlAtividade).success(function(atividades) {
			$scope.atividades = atividades;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar atividades " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.lancamento.codigo === undefined || $scope.lancamento.codigo === ""){
			$http.post(url,$scope.lancamento).success(function(lancamento) {
				$scope.lancamento.push(lancamento);
				$scope.novo();
				$scope.mensagens.push("Lancamento cadastrado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.lancamento).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Lancamento atualizado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	};
	
	$scope.pesquisarAluno();
	$scope.pesquisarAdministrador();
	$scope.pesquisarAtividade();
	$scope.pesquisar();
	$scope.novo();
});