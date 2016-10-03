package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.TurmaDao;
import model.domain.Turma;
import model.service.TurmaService;

public class TurmaServiceImpl implements TurmaService {

	@Inject
	private TurmaDao turmaDao;
	
	@Override
	public List<Turma> getTurmas(Turma turma){
		return turmaDao.getTurmas(turma);
	}
	
	@Override
	public List<Turma> getTurmasAtivas(){
		return turmaDao.getTurmasAtivas();
	}
	
	@Override
	@Transactional
	public Turma salvar(Turma turma){
		return turmaDao.salvar(turma);
	}
	
	@Override
	@Transactional
	public void atualizar(Turma turma){
		turmaDao.atualizar(turma);
	}
}