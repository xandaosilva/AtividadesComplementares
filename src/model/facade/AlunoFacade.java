package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Aluno;

public interface AlunoFacade {
	List<Aluno> getAlunosSemParametros();
	List<Aluno> getAlunosAtivos();
	List<Aluno> getAlunos(Integer codigo);
	
	@ValidateOnExecution
	Aluno salvar(@Valid Aluno aluno);
	
	@ValidateOnExecution
	void atualizar(@Valid Aluno aluno);
	void calcularAproveitamento(Integer codigo);
}