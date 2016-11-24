package model.dao;

import java.util.List;

import model.domain.Aluno;

public interface AlunoDao {
	Aluno salvar(Aluno aluno);
	void atualizar(Aluno aluno);
	List<Aluno> getAlunos(Aluno aluno);
	List<Aluno> getAlunosAtivos();
	List<Aluno> getAlunosPorTurma(int codigo);
}