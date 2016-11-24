package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Administrador;

public interface AdministradorFacade {
	List<Administrador> getAdministradoresSemParametros();
	List<Administrador> getAdministradoresAtivos();
	List<Administrador> getAdministradores(Integer codigo);
	
	@ValidateOnExecution
	Administrador salvar(@Valid Administrador administrador);
	
	@ValidateOnExecution
	void atualizar(@Valid Administrador administrador);
}