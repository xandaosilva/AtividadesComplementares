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
import model.domain.Curso;
import model.service.CursoService;

@Path("/curso")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CursoFacade {

	@Inject
	private CursoService cursoService;
	
	@GET
	public List<Curso> getCursosSemParametro(){
		return cursoService.getCursos(new Curso());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Curso> getCursos(@PathParam("codigo") Integer codigo){
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		return cursoService.getCursos(curso);
	}
	
	@POST
	public Curso salvar(Curso curso){
		return cursoService.salvar(curso);
	}
	
	@PUT
	public void atualizar(Curso curso){
		cursoService.atualizar(curso);
	}
}