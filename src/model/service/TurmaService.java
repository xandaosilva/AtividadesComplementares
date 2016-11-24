package model.service;

import java.util.*;
import model.domain.Turma;

public interface TurmaService {
	List<Turma> getTurmas(Turma turma);
	List<Turma> getTurmasAtivas();
	Turma salvar(Turma turma);
	void atualizar(Turma turma);
}