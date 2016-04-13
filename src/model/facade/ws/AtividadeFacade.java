package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Atividade;
import model.service.AtividadeService;

@WebService(serviceName="ws/atividade")
public class AtividadeFacade {

	@Inject
	private AtividadeService atividadeService;
	
	@WebMethod
	public List<Atividade> getAtividadesSemParametros(){
		return atividadeService.getAtividades(new Atividade());
	}
	
	@WebMethod
	public List<Atividade> getAtividades(@WebParam Atividade atividade){
		return atividadeService.getAtividades(atividade);
	}
	
	@WebMethod
	public Atividade salvar(@WebParam Atividade atividade){
		return atividadeService.salvar(atividade);
	}
	
	@WebMethod
	public void atualizar(@WebParam Atividade atividade){
		atividadeService.atualizar(atividade);
	}
}