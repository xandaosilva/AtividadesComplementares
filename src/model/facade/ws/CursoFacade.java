package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Curso;
import model.service.CursoService;

@WebService(serviceName="ws/curso")
public class CursoFacade {

	@Inject
	private CursoService cursoService;
	
	@WebMethod
	public List<Curso> getCursosSemParametros(){
		return cursoService.getCursos(new Curso());
	}
	
	@WebMethod
	public List<Curso> getCursos(@WebParam(name="codigo") Integer codigo){
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		return cursoService.getCursos(curso);
	}
	
	@WebMethod
	public Curso salvar(@WebParam(name="curso") Curso curso){
		return cursoService.salvar(curso);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="curso") Curso curso){
		cursoService.atualizar(curso);
	}
}