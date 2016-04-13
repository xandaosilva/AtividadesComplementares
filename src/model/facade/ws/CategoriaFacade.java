package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Categoria;
import model.service.CategoriaService;

@WebService(serviceName="ws/categoria")
public class CategoriaFacade {

	@Inject
	private CategoriaService categoriaService;
	
	@WebMethod
	public List<Categoria> getCategoriasSemParametros(){
		return categoriaService.getCategorias(new Categoria());
	}
	
	@WebMethod
	public List<Categoria> getCategorias(@WebParam Categoria categoria){
		return categoriaService.getCategorias(categoria);
	}
	
	@WebMethod
	public Categoria salvar(@WebParam Categoria categoria){
		return categoriaService.salvar(categoria);
	}
	
	@WebMethod
	public void atualizar(@WebParam Categoria categoria){
		categoriaService.atualizar(categoria);
	}
}