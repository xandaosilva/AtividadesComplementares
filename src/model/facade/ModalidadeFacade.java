package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Modalidade;

public interface ModalidadeFacade {
	List<Modalidade> getModalidadesSemParametros();
	List<Modalidade> getModalidadesAtivas();
	List<Modalidade> getModalidades(Integer codigo);
	
	@ValidateOnExecution
	Modalidade salvar(@Valid Modalidade modalidade);
	
	@ValidateOnExecution
	void atualizar(@Valid Modalidade modalidade);
}