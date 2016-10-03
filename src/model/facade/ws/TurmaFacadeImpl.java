package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.domain.Turma;
import model.facade.TurmaFacade;
import model.service.TurmaService;

@WebService(serviceName="ws/turma")
public class TurmaFacadeImpl implements TurmaFacade{

	@Inject
	private TurmaService turmaService;
	
	@Override
	@WebMethod
	public List<Turma> getTurmasSemParametros(){
		return turmaService.getTurmas(new Turma());
	}
	
	@Override
	@WebMethod
	public List<Turma> getTurmasAtivas(){
		return turmaService.getTurmasAtivas();
	}
	
	@Override
	@WebMethod
	public List<Turma> getTurmas(@WebParam(name="codigo") Integer codigo){
		Turma turma = new Turma();
		turma.setCodigo(codigo);
		return turmaService.getTurmas(turma);
	}
	
	@Override
	@WebMethod
	public Turma salvar(@WebParam(name="turma") Turma turma){
		return turmaService.salvar(turma);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="turma") Turma turma){
		turmaService.atualizar(turma);
	}
}