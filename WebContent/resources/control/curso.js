var cursoModule = angular.module("cursoModule",[]);

cursoModule.controller("cursoController", function($scope,$http) {
	
	url = "http://localhost:8080/AtividadesComplementares/rs/curso";
	urlAdministrador = "http://localhost:8080/AtividadesComplementares/rs/administrador/ativos";
	
	$scope.novo = function(){
		$scope.curso = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(curso){
		$scope.curso = curso;
	}
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(cursos) {
			$scope.cursos = cursos;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar cursos " + erro);
		});
	}
	
	$scope.pesquisarAdministrador = function(){
		$http.get(urlAdministrador).success(function(administradores) {
			$scope.administradores = administradores;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar administradores " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.curso.codigo === undefined || $scope.curso.codigo === ""){
			$http.post(url,$scope.curso).success(function(curso) {
				$scope.cursos.push($scope.curso);
				$scope.novo();
				$scope.mensagens.push("Curso cadastrado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.curso).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Curso atualizado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.pesquisarAdministrador();
	$scope.pesquisar();
	$scope.novo();
});