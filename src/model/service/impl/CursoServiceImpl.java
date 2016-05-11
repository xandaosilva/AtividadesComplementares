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
	
	@Override
	public List<Curso> getCursos(Curso curso){
		return cursoDao.getCursos(curso);
	}
	
	@Override
	@Transactional
	public Curso salvar(Curso curso){
		if(curso.validar() == true)
			return cursoDao.salvar(curso);
		else
			return null;
	}
	
	@Override
	@Transactional
	public void atualizar(Curso curso){
		if(curso.validar() == true)
			cursoDao.atualizar(curso);
		else
			return;
	}
}