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
	public List<Ppc> getPpcs(@WebParam Ppc ppc){
		return ppcService.getPpcs(ppc);
	}
	
	@WebMethod
	public Ppc salvar(@WebParam Ppc ppc){
		return ppcService.salvar(ppc);
	}
	
	@WebMethod
	public void atualizar(@WebParam Ppc ppc){
		ppcService.atualizar(ppc);
	}
}