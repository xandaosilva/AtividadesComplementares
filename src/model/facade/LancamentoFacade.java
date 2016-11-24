package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Lancamento;

public interface LancamentoFacade {
	List<Lancamento> getLancamentosSemParametros();
	List<Lancamento> getLancamentosAtivos();
	List<Lancamento> getLancamentos(Integer codigo);
	
	@ValidateOnExecution
	Lancamento salvar(@Valid Lancamento lancamento);
	
	@ValidateOnExecution
	void atualizar(@Valid Lancamento lancamento);
}