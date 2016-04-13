package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.AlunoDao;
import model.domain.Aluno;
import model.service.AlunoService;

public class AlunoServiceImpl implements AlunoService {

	@Inject
	private AlunoDao alunoDao;
	
	/* (non-Javadoc)
	 * @see model.service.AlunoService#getAlunos(model.domain.Aluno)
	 */
	@Override
	public List<Aluno> getAlunos(Aluno aluno){
		return alunoDao.getAlunos(aluno);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AlunoService#salvar(model.domain.Aluno)
	 */
	@Override
	@Transactional
	public Aluno salvar(Aluno aluno){
		return alunoDao.salvar(aluno);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AlunoService#atualizar(model.domain.Aluno)
	 */
	@Override
	@Transactional
	public void atualizar(Aluno aluno){
		alunoDao.atualizar(aluno);
	}
}