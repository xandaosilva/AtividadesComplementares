var alunoModule = angular.module("alunoModule",[]);

alunoModule.controller("alunoController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/aluno";
	urlTurma = "http://localhost:8080/AtividadesComplementares/rs/turma/ativas";
	
	$scope.novo = function(){
		$scope.aluno = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(aluno){
		$scope.aluno = aluno;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(alunos) {
			$scope.alunos = alunos;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar alunos " + erro);
		});
	}
	
	$scope.pesquisarTurma = function(){
		$http.get(urlTurma).success(function(turmas) {
			$scope.turmas = turmas;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar turmas " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.aluno.codigo === undefined || $scope.aluno.codigo === ""){
			$http.post(url,$scope.aluno).success(function(aluno) {
				$scope.aluno.push(aluno);
				$scope.novo();
				$scope.mensagens.push("Aluno salvo com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.aluno).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Aluno atualizado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.pesquisarTurma();
	$scope.pesquisar();
	$scope.novo();
});