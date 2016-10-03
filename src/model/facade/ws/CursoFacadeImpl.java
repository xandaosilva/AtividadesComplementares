package model.facade.ws;

import java.util.*;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import model.domain.Curso;
import model.facade.CursoFacade;
import model.service.CursoService;

@WebService(serviceName="ws/curso")
public class CursoFacadeImpl implements CursoFacade{

	@Inject
	private CursoService cursoService;
	
	@Override
	@WebMethod
	public List<Curso> getCursosSemParametros(){
		return cursoService.getCursos(new Curso());
	}
	
	@Override
	@WebMethod
	public List<Curso> getCursosAtivos(){
		return cursoService.getCursosAtivos();
	}
	
	@Override
	@WebMethod
	public List<Curso> getCursos(@WebParam(name="codigo") Integer codigo){
		Curso curso = new Curso();
		curso.setCodigo(codigo);
		return cursoService.getCursos(curso);
	}
	
	@Override
	@WebMethod
	public Curso salvar(@WebParam(name="curso") Curso curso){
		return cursoService.salvar(curso);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="curso") Curso curso){
		cursoService.atualizar(curso);
	}
}