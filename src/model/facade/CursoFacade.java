package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Curso;

public interface CursoFacade {
	public List<Curso> getCursosSemParametros();
	public List<Curso> getCursosAtivos();
	public List<Curso> getCursos(Integer codigo);

	@ValidateOnExecution
	public Curso salvar(@Valid Curso curso);

	@ValidateOnExecution
	public void atualizar(@Valid Curso curso);
}