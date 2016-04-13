package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Aluno;
import model.service.AlunoService;

@WebService(serviceName="ws/aluno")
public class AlunoFacade {

	@Inject
	private AlunoService alunoService;
	
	@WebMethod
	public List<Aluno> getAlunosSemParametros(){
		return alunoService.getAlunos(new Aluno());
	}
	
	@WebMethod
	public List<Aluno> getAlunos(@WebParam Aluno aluno){
		return alunoService.getAlunos(aluno);
	}
	
	@WebMethod
	public Aluno salvar(@WebParam Aluno aluno){
		return alunoService.salvar(aluno);
	}
	
	@WebMethod
	public void atualizar(@WebParam Aluno aluno){
		alunoService.atualizar(aluno);
	}
}