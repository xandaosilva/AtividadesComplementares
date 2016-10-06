package model.dao;

import java.util.List;

import model.domain.Aluno;

public interface AlunoDao {
	public Aluno salvar(Aluno aluno);
	public void atualizar(Aluno aluno);
	public List<Aluno> getAlunos(Aluno aluno);
	public List<Aluno> getAlunosAtivos();
}