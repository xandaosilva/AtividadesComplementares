package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Modalidade;
import model.service.ModalidadeService;

@WebService(serviceName="modalidade")
public class ModalidadeFacade {

	@Inject
	private ModalidadeService modalidadeService;
	
	@WebMethod
	public List<Modalidade> getModalidadesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@WebMethod
	public List<Modalidade> getModalidades(@WebParam Modalidade modalidade){
		return modalidadeService.getModalidades(modalidade);
	}
	
	@WebMethod
	public Modalidade salvar(@WebParam Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@WebMethod
	public void atualizar(@WebParam Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
}