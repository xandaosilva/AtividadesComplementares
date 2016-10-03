package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Ppc;
import model.facade.PpcFacade;
import model.service.PpcService;

@WebService(serviceName="ws/ppc")
public class PpcFacadeImpl implements PpcFacade{

	@Inject
	private PpcService ppcService;
	
	@Override
	@WebMethod
	public List<Ppc> getPpcsSemParametros(){
		return ppcService.getPpcs(new Ppc());
	}
	
	@Override
	@WebMethod
	public List<Ppc> getPpcsAtivos(){
		return ppcService.getPpcsAtivos();
	}
	
	@Override
	@WebMethod
	public List<Ppc> getPpcs(@WebParam(name="codigo") Integer codigo){
		Ppc ppc = new Ppc();
		ppc.setCodigo(codigo);
		return ppcService.getPpcs(ppc);
	}
	
	@Override
	@WebMethod
	public Ppc salvar(@WebParam(name="ppc") Ppc ppc){
		return ppcService.salvar(ppc);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="ppc") Ppc ppc){
		ppcService.atualizar(ppc);
	}
}