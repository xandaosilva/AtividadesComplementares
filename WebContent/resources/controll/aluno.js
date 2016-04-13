var alunoModule = angular.module("alunoModule",[]);

alunoModule.controller("alunoController", function($scope,$http) {
	url = "http://localhost:8080/Atividades/rs/aluno";
	
	$scope.novo = function(){
		$scope.aluno = "";
	};
	
	$scope.seleciona = function(aluno){
		$scope.aluno = aluno;
	};
	
	$scope.pesquisar = function(){
		$http.get(url).success(function(alunos) {
			$scope.alunos = alunos;
		}).error(function(erro) {
			alert(erro);
		});
	};
	
	$scope.salvar = function(){
		if($scope.aluno.codigo === ""){
			$http.post(url,$scope.aluno).success(function(aluno) {
				$scope.aluno.push(aluno);
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
		else{
			$hhtp.put(url,$scope.aluno).success(function() {
				$scope.pesquisar();
				$scope.novo();
			}).error(function(erro){
				alert(erro);
			});
		}
	};
	
	$scope.pesquisar();
});