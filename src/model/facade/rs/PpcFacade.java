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
import model.domain.Ppc;
import model.service.PpcService;

@Path("/ppc")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class PpcFacade {

	@Inject
	private PpcService ppcService;
	
	@GET
	public List<Ppc> getPpcsSemParametros(){
		return ppcService.getPpcs(new Ppc());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Ppc> getPpcs(@PathParam("codigo") Long codigo){
		Ppc ppc = new Ppc();
		ppc.setCodigo(codigo);
		return ppcService.getPpcs(ppc);
	}
	
	@POST
	public Ppc salvar(Ppc ppc){
		return ppcService.salvar(ppc);
	}
	
	@PUT
	public void atualizar(Ppc ppc){
		ppcService.atualizar(ppc);
	}
}