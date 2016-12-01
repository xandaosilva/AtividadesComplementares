package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Lancamento;
import model.facade.LancamentoFacade;
import model.service.LancamentoService;

@WebService(serviceName="ws/lancamento")
public class LancamentoFacadeImpl implements LancamentoFacade{

	@Inject
	private LancamentoService lancamentoService;
	
	@Override
	@WebMethod
	public List<Lancamento> getLancamentosSemParametros(){
		return lancamentoService.getLancamentos(new Lancamento());
	}
	
	@Override
	@WebMethod
	public List<Lancamento> getLancamentosAtivos(){
		return lancamentoService.getLancamentosAtivos();
	}
	
	@Override
	@WebMethod
	public List<Lancamento> getLancamentos(@WebParam(name="codigo") Integer codigo){
		Lancamento lancamento = new Lancamento();
		lancamento.setCodigo(codigo);
		return lancamentoService.getLancamentos(lancamento);
	}
	
	@Override
	@WebMethod
	public List<Lancamento> getLancamentosAtivosPorAluno(@WebParam(name="codigo") Integer codigo){
		return lancamentoService.getLancamentosAtivosPorAluno(codigo);
	}
	
	@Override
	@WebMethod
	public Lancamento salvar(@WebParam(name="lancamento") Lancamento lancamento){
		return lancamentoService.salvar(lancamento);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="lancamento") Lancamento lancamento){
		lancamentoService.atualizar(lancamento);
	}
}