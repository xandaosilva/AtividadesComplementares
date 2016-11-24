package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Turma;

public interface TurmaFacade {
	List<Turma> getTurmasSemParametros();
	List<Turma> getTurmasAtivas();
	List<Turma> getTurmas(Integer codigo);

	@ValidateOnExecution
	Turma salvar(@Valid Turma turma);

	@ValidateOnExecution
	void atualizar(@Valid Turma turma);
}