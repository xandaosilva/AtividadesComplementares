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
	
	@Override
	public List<Aluno> getAlunos(Aluno aluno){
		return alunoDao.getAlunos(aluno);
	}
	
	@Override
	@Transactional
	public Aluno salvar(Aluno aluno){
		if(aluno.validar() == true)
			return alunoDao.salvar(aluno);
		else
			return null;
	}
	
	@Override
	@Transactional
	public void atualizar(Aluno aluno){
		if(aluno.validar() == true)
			alunoDao.atualizar(aluno);
		else 
			return;
	}
}