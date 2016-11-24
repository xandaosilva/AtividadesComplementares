package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Atividade;

public interface AtividadeFacade {
	List<Atividade> getAtividadesSemParametros();
	List<Atividade> getAtividadesAtivas();
	List<Atividade> getAtividades(Integer codigo);
	
	@ValidateOnExecution
	Atividade salvar(@Valid Atividade atividade);
	
	@ValidateOnExecution
	void atualizar(@Valid Atividade atividade);
}