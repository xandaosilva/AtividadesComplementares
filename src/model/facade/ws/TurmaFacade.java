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
	public List<Turma> getTurmas(@WebParam(name="codigo") Integer codigo){
		Turma turma = new Turma();
		turma.setCodigo(codigo);
		return turmaService.getTurmas(turma);
	}
	
	@WebMethod
	public Turma salvar(@WebParam(name="turma") Turma turma){
		return turmaService.salvar(turma);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="turma") Turma turma){
		turmaService.atualizar(turma);
	}
}