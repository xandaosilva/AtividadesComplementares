package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Atividade;

public interface AtividadeFacade {
	public List<Atividade> getAtividadesSemParametros();
	public List<Atividade> getAtividadesAtivas();
	public List<Atividade> getAtividades(Integer codigo);
	
	@ValidateOnExecution
	public Atividade salvar(@Valid Atividade atividade);
	
	@ValidateOnExecution
	public void atualizar(@Valid Atividade atividade);
}