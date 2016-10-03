package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Modalidade;
import model.facade.ModalidadeFacade;
import model.service.ModalidadeService;

@WebService(serviceName="modalidade")
public class ModalidadeFacadeImpl implements ModalidadeFacade{

	@Inject
	private ModalidadeService modalidadeService;
	
	@Override
	@WebMethod
	public List<Modalidade> getModalidadesSemParametros(){
		return modalidadeService.getModalidades(new Modalidade());
	}
	
	@Override
	@WebMethod
	public List<Modalidade> getModalidadesAtivas(){
		return modalidadeService.getModalidadesAtivas();
	}
	
	@Override
	@WebMethod
	public List<Modalidade> getModalidades(@WebParam(name="codigo") Integer codigo){
		Modalidade modalidade = new Modalidade();
		modalidade.setCodigo(codigo);
		return modalidadeService.getModalidades(modalidade);
	}
	
	@Override
	@WebMethod
	public Modalidade salvar(@WebParam(name="modalidade") Modalidade modalidade){
		return modalidadeService.salvar(modalidade);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="modalidade") Modalidade modalidade){
		modalidadeService.atualizar(modalidade);
	}
}