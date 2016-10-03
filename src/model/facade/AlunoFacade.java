package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Aluno;

public interface AlunoFacade {
	public List<Aluno> getAlunosSemParametros();
	public List<Aluno> getAlunosAtivos();
	public List<Aluno> getAlunos(Integer codigo);
	
	@ValidateOnExecution
	public Aluno salvar(@Valid Aluno aluno);
	
	@ValidateOnExecution
	public void atualizar(@Valid Aluno aluno);
}