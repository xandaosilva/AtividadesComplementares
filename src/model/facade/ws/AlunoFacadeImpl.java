package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.domain.Aluno;
import model.facade.AlunoFacade;
import model.service.AlunoService;

@WebService(serviceName="ws/aluno")
public class AlunoFacadeImpl implements AlunoFacade{

	@Inject
	private AlunoService alunoService;
	
	@Override
	@WebMethod
	public List<Aluno> getAlunosSemParametros(){
		return alunoService.getAlunos(new Aluno());
	}
	
	@Override
	@WebMethod
	public List<Aluno> getAlunosAtivos(){
		return alunoService.getAlunosAtivos();
	}
	
	@Override
	@WebMethod
	public List<Aluno> getAlunos(@WebParam(name="codigo") Integer codigo){
		Aluno aluno = new Aluno();
		aluno.setCodigo(codigo);
		return alunoService.getAlunos(aluno);
	}
		
	@Override
	@WebMethod
	public Aluno salvar(@WebParam(name="aluno") Aluno aluno){
		return alunoService.salvar(aluno);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="aluno") Aluno aluno){
		alunoService.atualizar(aluno);
	}
	
	@Override
	@WebMethod
	public void calcularAproveitamento(@WebParam(name="codigo") Integer codigo){
		
	}
	
	@Override
	@WebMethod
	public void gerarRelatorio(@WebParam(name="codigo") int codigo){
		
	}
}