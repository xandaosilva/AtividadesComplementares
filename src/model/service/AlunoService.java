package model.service;

import java.util.*;
import model.domain.Aluno;

public interface AlunoService {
	List<Aluno> getAlunos(Aluno aluno);
	List<Aluno> getAlunosAtivos();
	Aluno salvar(Aluno aluno);
	void atualizar(Aluno aluno);
}