package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Administrador;
import model.facade.AdministradorFacade;
import model.service.AdministradorService;

@WebService(serviceName="ws/administrador")
public class AdministradorFacadeImpl implements AdministradorFacade{

	@Inject
	private AdministradorService administradorService;
	
	@Override
	@WebMethod
	public List<Administrador> getAdministradoresSemParametros(){
		return administradorService.getAdministradores(new Administrador());
	}
	
	@Override
	@WebMethod
	public List<Administrador> getAdministradoresAtivos(){
		return administradorService.getAdministradoresAtivos();
	}
	
	@Override
	@WebMethod
	public List<Administrador> getAdministradores(@WebParam(name="codigo") Integer codigo){
		Administrador administrador = new Administrador();
		administrador.setCodigo(codigo);
		return administradorService.getAdministradores(administrador);
	}
	
	@Override
	@WebMethod
	public Administrador salvar(@WebParam(name="administrador") Administrador administrador){
		return administradorService.salvar(administrador);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="administrador") Administrador administrador){
		administradorService.atualizar(administrador);
	}
}