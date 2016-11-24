package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Curso;

public interface CursoFacade {
	List<Curso> getCursosSemParametros();
	List<Curso> getCursosAtivos();
	List<Curso> getCursos(Integer codigo);

	@ValidateOnExecution
	Curso salvar(@Valid Curso curso);

	@ValidateOnExecution
	void atualizar(@Valid Curso curso);
}