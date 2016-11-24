package model.service;

import java.util.*;
import model.domain.Curso;

public interface CursoService {
	List<Curso> getCursos(Curso curso);
	List<Curso> getCursosAtivos();
	Curso salvar(Curso curso);
	void atualizar(Curso curso);
}