package model.facade;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import model.domain.Administrador;

public interface AdministradorFacade {
	public List<Administrador> getAdministradoresSemParametros();
	public List<Administrador> getAdministradoresAtivos();
	public List<Administrador> getAdministradores(Integer codigo);
	
	@ValidateOnExecution
	public Administrador salvar(@Valid Administrador administrador);
	
	@ValidateOnExecution
	public void atualizar(@Valid Administrador administrador);
}