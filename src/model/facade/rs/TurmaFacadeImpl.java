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
import model.facade.TurmaFacade;
import model.service.TurmaService;

@Path("/turma")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class TurmaFacadeImpl implements TurmaFacade{

	@Inject
	private TurmaService turmaService;
	
	@Override
	@GET
	public List<Turma> getTurmasSemParametros(){
		return turmaService.getTurmas(new Turma());
	}
	
	@Override
	@GET
	@Path("/ativas")
	public List<Turma> getTurmasAtivas(){
		return turmaService.getTurmasAtivas();
	}
	
	@Override
	@GET
	@Path("/{codigo}")
	public List<Turma> getTurmas(@PathParam("codigo") Integer codigo){
		Turma turma = new Turma();
		turma.setCodigo(codigo);
		return turmaService.getTurmas(turma);
	}
	
	@Override
	@POST
	public Turma salvar(Turma turma){
		return turmaService.salvar(turma);
	}
	
	@Override
	@PUT
	public void atualizar(Turma turma){
		turmaService.atualizar(turma);
	}
}