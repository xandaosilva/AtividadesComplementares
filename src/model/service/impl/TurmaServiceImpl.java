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
	@Transactional
	public Turma salvar(Turma turma){
		if(turma.validar() == true)
			return turmaDao.salvar(turma);
		else
			return null;
	}
	
	@Override
	@Transactional
	public void atualizar(Turma turma){
		if(turma.validar() == true)
			turmaDao.atualizar(turma);
		else
			return;
	}
}