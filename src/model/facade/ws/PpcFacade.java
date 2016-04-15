package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Ppc;
import model.service.PpcService;

@WebService(serviceName="ws/ppc")
public class PpcFacade {

	@Inject
	private PpcService ppcService;
	
	@WebMethod
	public List<Ppc> getPpcSemParametros(){
		return ppcService.getPpcs(new Ppc());
	}
	
	@WebMethod
	public List<Ppc> getPpcs(@WebParam(name="codigo") Integer codigo){
		Ppc ppc = new Ppc();
		ppc.setCodigo(codigo);
		return ppcService.getPpcs(ppc);
	}
	
	@WebMethod
	public Ppc salvar(@WebParam(name="ppc") Ppc ppc){
		return ppcService.salvar(ppc);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="ppc") Ppc ppc){
		ppcService.atualizar(ppc);
	}
}