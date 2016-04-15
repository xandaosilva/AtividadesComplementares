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
import model.service.ModalidadeService;

@Path("/modalidade")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class ModalidadeFacade {

	@Inject
	private ModalidadeService modalidadeService;
	
	@GET
	public List<Modalidade> getModalidadesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Modalidade> getModalidades(@PathParam("codigo") Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		return modalidadeService.getModalidades(modalidade);
	}
	
	@POST
	public Modalidade salvar(Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@PUT
	public void atualizar(Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
}