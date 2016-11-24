package model.dao;

import java.util.*;
import model.domain.Curso;

public interface CursoDao {
	Curso salvar(Curso curso);
	void atualizar(Curso curso);
	List<Curso> getCursos(Curso curso);
	List<Curso> getCursosAtivos();
}