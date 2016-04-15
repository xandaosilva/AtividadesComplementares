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
import model.service.AdministradorService;

@Path("/administrador")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AdministradorFacade {

	@Inject
	private AdministradorService administradorService;
	
	@GET
	public List<Administrador> getAdministradorSemParametros(){
		return administradorService.getAdministradores(new Administrador());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Administrador> getAdministrador(@PathParam("codigo") Integer codigo){
		Administrador administrador = new Administrador();
		administrador.setCodigo(codigo);
		return administradorService.getAdministradores(administrador);
	}
	
	@POST
	public Administrador salvar(Administrador administrador){
		return administradorService.salvar(administrador);
	}
	
	@PUT
	public void atualizar(Administrador administrador){
		administradorService.atualizar(administrador);
	}
}