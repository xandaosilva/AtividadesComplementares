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
import model.facade.PpcFacade;
import model.service.PpcService;

@Path("/ppc")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class PpcFacadeImpl implements PpcFacade{

	@Inject
	private PpcService ppcService;
	
	@Override
	@GET
	public List<Ppc> getPpcsSemParametros(){
		return ppcService.getPpcs(new Ppc());
	}
	
	@Override
	@GET
	@Path("/ativos")
	public List<Ppc> getPpcsAtivos(){
		return ppcService.getPpcsAtivos();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Ppc> getPpcs(@PathParam("codigo") Integer codigo){
		Ppc ppc = new Ppc();
		ppc.setCodigo(codigo);
		return ppcService.getPpcs(ppc);
	}
	
	@Override
	@POST
	public Ppc salvar(Ppc ppc){
		return ppcService.salvar(ppc);
	}
	
	@Override
	@PUT
	public void atualizar(Ppc ppc){
		ppcService.atualizar(ppc);
	}
}