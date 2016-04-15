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
import model.domain.Turma;
import model.service.TurmaService;

@Path("/turma")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TurmaFacade {

	@Inject
	private TurmaService turmaService;
	
	@GET
	public List<Turma> getTurmasSemParametros(){
		return turmaService.getTurmas(new Turma());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Turma> getTurmas(@PathParam("codigo") Integer codigo){
		Turma turma = new Turma();
		turma.setCodigo(codigo);
		return turmaService.getTurmas(turma);
	}
	
	@POST
	public Turma salvar(Turma turma){
		return turmaService.salvar(turma);
	}
	
	@PUT
	public void atualizar(Turma turma){
		turmaService.atualizar(turma);
	}
}