package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Ppc;

public interface PpcFacade {
	List<Ppc> getPpcsSemParametros();
	List<Ppc> getPpcsAtivos();
	List<Ppc> getPpcs(Integer codigo);

	@ValidateOnExecution
	Ppc salvar(@Valid Ppc ppc);

	@ValidateOnExecution
	void atualizar(@Valid Ppc ppc);
}