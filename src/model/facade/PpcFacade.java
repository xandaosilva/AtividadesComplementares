package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Ppc;

public interface PpcFacade {
	public List<Ppc> getPpcsSemParametros();
	public List<Ppc> getPpcsAtivos();
	public List<Ppc> getPpcs(Integer codigo);

	@ValidateOnExecution
	public Ppc salvar(@Valid Ppc ppc);

	@ValidateOnExecution
	public void atualizar(@Valid Ppc ppc);
}