package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Turma;

public interface TurmaFacade {
	public List<Turma> getTurmasSemParametros();
	public List<Turma> getTurmasAtivas();
	public List<Turma> getTurmas(Integer codigo);

	@ValidateOnExecution
	public Turma salvar(@Valid Turma turma);

	@ValidateOnExecution
	public void atualizar(@Valid Turma turma);
}