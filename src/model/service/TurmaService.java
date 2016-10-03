package model.service;

import java.util.*;
import model.domain.Turma;

public interface TurmaService {
	public List<Turma> getTurmas(Turma turma);
	public List<Turma> getTurmasAtivas();
	public Turma salvar(Turma turma);
	public void atualizar(Turma turma);
}