package model.service;

import java.util.*;
import model.domain.Aluno;

public interface AlunoService {
	public List<Aluno> getAlunos(Aluno aluno);
	public Aluno salvar(Aluno aluno);
	public void atualizar(Aluno aluno);
}