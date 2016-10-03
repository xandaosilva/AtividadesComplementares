package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Atividade;
import model.facade.AtividadeFacade;
import model.service.AtividadeService;

@WebService(serviceName="ws/atividade")
public class AtividadeFacadeImpl implements AtividadeFacade{

	@Inject
	private AtividadeService atividadeService;
	
	@Override
	@WebMethod
	public List<Atividade> getAtividadesSemParametros(){
		return atividadeService.getAtividades(new Atividade());
	}
	
	@Override
	@WebMethod
	public List<Atividade> getAtividadesAtivas(){
		return atividadeService.getAtividadesAtivas();
	}
	
	@Override
	@WebMethod
	public List<Atividade> getAtividades(@WebParam(name="codigo") Integer codigo){
		Atividade atividade = new Atividade();
		atividade.setCodigo(codigo);
		return atividadeService.getAtividades(atividade);
	}
	
	@Override
	@WebMethod
	public Atividade salvar(@WebParam(name="atividade") Atividade atividade){
		return atividadeService.salvar(atividade);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="atividade") Atividade atividade){
		atividadeService.atualizar(atividade);
	}
}