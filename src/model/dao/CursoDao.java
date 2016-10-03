package model.dao;

import java.util.*;
import model.domain.Curso;

public interface CursoDao {
	public Curso salvar(Curso curso);
	public void atualizar(Curso curso);
	public List<Curso> getCursos(Curso curso);
	public List<Curso> getCursosAtivos();
}