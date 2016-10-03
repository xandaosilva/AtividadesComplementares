package model.facade.rs;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import model.domain.Administrador;
import model.facade.AdministradorFacade;
import model.service.AdministradorService;

@Path("/administrador")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AdministradorFacadeImpl implements AdministradorFacade{

	@Inject
	private AdministradorService administradorService;
	
	@Override
	@GET
	public List<Administrador> getAdministradoresSemParametros(){
		return administradorService.getAdministradores(new Administrador());
	}
	
	@Override
	@GET
	@Path("/ativos")
	public List<Administrador> getAdministradoresAtivos(){
		return administradorService.getAdministradoresAtivos();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Administrador> getAdministradores(@PathParam("codigo") Integer codigo){
		Administrador administrador = new Administrador();
		administrador.setCodigo(codigo);
		return administradorService.getAdministradores(administrador);
	}
	
	@Override
	@POST
	public Administrador salvar(Administrador administrador){
		return administradorService.salvar(administrador);
	}
	
	@Override
	@PUT
	public void atualizar(Administrador administrador){
		administradorService.atualizar(administrador);
	}
}