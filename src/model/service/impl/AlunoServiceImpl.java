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
	public List<Aluno> getAlunosAtivos(){
		return alunoDao.getAlunosAtivos();
	}
	
	@Override
	@Transactional
	public Aluno salvar(Aluno aluno){
		return alunoDao.salvar(aluno);
	}
	
	@Override
	@Transactional
	public void atualizar(Aluno aluno){
		alunoDao.atualizar(aluno);
	}
	
	@Override
	public Aluno getAlunoPorCodigo(int codigo){
		return alunoDao.getAlunoPorCodigo(codigo);
	}
}