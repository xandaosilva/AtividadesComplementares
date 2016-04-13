package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Turma;
import model.service.TurmaService;

@WebService(serviceName="ws/turma")
public class TurmaFacade {

	@Inject
	private TurmaService turmaService;
	
	@WebMethod
	public List<Turma> getTurmasSemParametros(){
		return turmaService.getTurmas(new Turma());
	}
	
	@WebMethod
	public List<Turma> getTurmas(@WebParam Turma turma){
		return turmaService.getTurmas(turma);
	}
	
	@WebMethod
	public Turma salvar(@WebParam Turma turma){
		return turmaService.salvar(turma);
	}
	
	@WebMethod
	public void atualizar(@WebParam Turma turma){
		turmaService.atualizar(turma);
	}
}