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
import model.domain.Aluno;
import model.service.AlunoService;

@Path("/aluno")
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoFacade {

	@Inject
	private AlunoService alunoService;
	
	@GET
	public List<Aluno> getAlunoSemParametros(){
		return alunoService.getAlunos(new Aluno());
	}
	
	@GET
	@Path("/{codigo}")
	public List<Aluno> getAluno(@PathParam("codigo") Integer codigo){
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		return alunoService.getAlunos(aluno);
	}
	
	@POST
	public Aluno salvar(Aluno aluno){
		return alunoService.salvar(aluno);
	}
	
	@PUT
	public void atualizar(Aluno aluno){
		alunoService.atualizar(aluno);
	}
}