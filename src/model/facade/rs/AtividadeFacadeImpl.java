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
import model.domain.Atividade;
import model.facade.AtividadeFacade;
import model.service.AtividadeService;

@Path("/atividade")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AtividadeFacadeImpl implements AtividadeFacade{

	@Inject
	private AtividadeService atividadeService;
	
	@Override
	@GET
	public List<Atividade> getAtividadesSemParametros(){
		return atividadeService.getAtividades(new Atividade());
	}
	
	@Override
	@GET
	@Path("/ativas")
	public List<Atividade> getAtividadesAtivas(){
		return atividadeService.getAtividadesAtivas();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Atividade> getAtividades(@PathParam("codigo") Integer codigo){
		Atividade atividade = new Atividade();
		atividade.setCodigo(codigo);
		return atividadeService.getAtividades(atividade);
	}
	
	@Override
	@POST
	public Atividade salvar(Atividade atividade){
		return atividadeService.salvar(atividade);
	}
	
	@Override
	@PUT
	public void atualizar(Atividade atividade){
		atividadeService.atualizar(atividade);
	}
}