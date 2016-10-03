package model.dao;

import java.util.*;
import model.domain.Turma;

public interface TurmaDao {
	public Turma salvar(Turma turma);
	public void atualizar(Turma turma);
	public List<Turma> getTurmas(Turma turma);
	public List<Turma> getTurmasAtivas();
}