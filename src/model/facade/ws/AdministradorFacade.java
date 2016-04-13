package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Administrador;
import model.service.AdministradorService;

@WebService(serviceName="ws/administrador")
public class AdministradorFacade {

	@Inject
	private AdministradorService administradorService;
	
	@WebMethod
	public List<Administrador> getAdministradoresSemParametros(){
		return administradorService.getAdministradores(new Administrador());
	}
	
	@WebMethod
	public List<Administrador> getAdministradores(@WebParam Administrador administrador){
		return administradorService.getAdministradores(administrador);
	}
	
	@WebMethod
	public Administrador salvar(@WebParam Administrador administrador){
		return administradorService.salvar(administrador);
	}
	
	@WebMethod
	public void atualizar(@WebParam Administrador administrador){
		administradorService.atualizar(administrador);
	}
}