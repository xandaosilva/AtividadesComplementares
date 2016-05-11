package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Lancamento;
import model.service.LancamentoService;

@WebService(serviceName="ws/lancamento")
public class LancamentoFacade {

	@Inject
	private LancamentoService lancamentoService;
	
	@WebMethod
	public List<Lancamento> getAtividadesSemParametros(){
		return lancamentoService.getLancamentos(new Lancamento());
	}
	
	@WebMethod
	public List<Lancamento> getAtividades(@WebParam(name="codigo") Integer codigo){
		Lancamento lancamento = new Lancamento();
		lancamento.setCodigo(codigo);
		return lancamentoService.getLancamentos(lancamento);
	}
	
	@WebMethod
	public Lancamento salvar(@WebParam(name="lancamento") Lancamento lancamento){
		return lancamentoService.salvar(lancamento);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="lancamento") Lancamento lancamento){
		lancamentoService.atualizar(lancamento);
	}
}