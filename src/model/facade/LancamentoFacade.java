package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Lancamento;

public interface LancamentoFacade {
	public List<Lancamento> getLancamentosSemParametros();
	public List<Lancamento> getLancamentosAtivos();
	public List<Lancamento> getLancamentos(Integer codigo);
	
	@ValidateOnExecution
	public Lancamento salvar(@Valid Lancamento lancamento);
	
	@ValidateOnExecution
	public void atualizar(@Valid Lancamento lancamento);
}