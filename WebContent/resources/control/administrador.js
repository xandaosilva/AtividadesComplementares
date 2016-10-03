var administradorModule = angular.module("administradorModule",[]);

administradorModule.controller("administradorController", function($scope,$http) {
	url = "http://localhost:8080/AtividadesComplementares/rs/administrador";
	
	$scope.novo = function(){
		$scope.administrador = "";
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push("Falha de validação retornada do servidor");
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.seleciona = function(administrador){
		$scope.administrador = administrador;
	}

	$scope.pesquisar = function(){
		$http.get(url).success(function(administradores) {
			$scope.administradores = administradores;
		}).error(function(erro) {
			$scope.mensagens.push("Erro ao pesquisar administradores " + erro);
		});
	}
	
	$scope.salvar = function(){
		if($scope.administrador.codigo === undefined || $scope.administrador.codigo === ""){
			$http.post(url,$scope.administrador).success(function(administrador) {
				$scope.administrador.push(administrador);
				$scope.novo();
				$scope.mensagens.push("Administrador salvo com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
		else{
			$http.put(url,$scope.administrador).success(function() {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push("Administrador atualizado com sucesso");
			}).error(function(erro){
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}
	}
	
	$scope.pesquisar();
	$scope.novo();
});