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
import model.domain.Modalidade;
import model.facade.ModalidadeFacade;
import model.service.ModalidadeService;

@Path("/modalidade")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ModalidadeFacadeImpl implements ModalidadeFacade{

	@Inject
	private ModalidadeService modalidadeService;
	
	@Override
	@GET
	public List<Modalidade> getModalidadesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@Override
	@GET
	@Path("/ativas")
	public List<Modalidade> getModalidadesAtivas(){
		return modalidadeService.getModalidadesAtivas();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Modalidade> getModalidades(@PathParam("codigo") Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		return modalidadeService.getModalidades(modalidade);
	}
	
	@Override
	@POST
	public Modalidade salvar(Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@Override
	@PUT
	public void atualizar(Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
}