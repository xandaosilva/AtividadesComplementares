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
	
	/* (non-Javadoc)
	 * @see model.service.TurmaService#getTurmas(model.domain.Turma)
	 */
	@Override
	public List<Turma> getTurmas(Turma turma){
		return turmaDao.getTurmas(turma);
	}
	
	/* (non-Javadoc)
	 * @see model.service.TurmaService#salvar(model.domain.Turma)
	 */
	@Override
	@Transactional
	public Turma salvar(Turma turma){
		return turmaDao.salvar(turma);
	}
	
	/* (non-Javadoc)
	 * @see model.service.TurmaService#atualizar(model.domain.Turma)
	 */
	@Override
	@Transactional
	public void atualizar(Turma turma){
		turmaDao.atualizar(turma);
	}
}