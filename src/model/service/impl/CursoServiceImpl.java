package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.CursoDao;
import model.domain.Curso;
import model.service.CursoService;

public class CursoServiceImpl implements CursoService {

	@Inject
	private CursoDao cursoDao;
	
	/* (non-Javadoc)
	 * @see model.service.CursoService#getCursos(model.domain.Curso)
	 */
	@Override
	public List<Curso> getCursos(Curso curso){
		return cursoDao.getCursos(curso);
	}
	
	/* (non-Javadoc)
	 * @see model.service.CursoService#salvar(model.domain.Curso)
	 */
	@Override
	@Transactional
	public Curso salvar(Curso curso){
		return cursoDao.salvar(curso);
	}
	
	/* (non-Javadoc)
	 * @see model.service.CursoService#atualizar(model.domain.Curso)
	 */
	@Override
	@Transactional
	public void atualizar(Curso curso){
		cursoDao.atualizar(curso);
	}
}