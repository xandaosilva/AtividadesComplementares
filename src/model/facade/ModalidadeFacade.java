package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Modalidade;

public interface ModalidadeFacade {
	public List<Modalidade> getModalidadesSemParametros();
	public List<Modalidade> getModalidadesAtivas();
	public List<Modalidade> getModalidades(Integer codigo);
	
	@ValidateOnExecution
	public Modalidade salvar(@Valid Modalidade modalidade);
	
	@ValidateOnExecution
	void atualizar(@Valid Modalidade modalidade);
}