package model.dao;

import java.util.List;

import model.domain.Turma;

public interface TurmaDao {
	Turma salvar(Turma turma);
	void atualizar(Turma turma);
	List<Turma> getTurmas(Turma turma);
	List<Turma> getTurmasAtivas();
}