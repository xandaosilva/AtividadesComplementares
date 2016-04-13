package model.dao;

import java.util.*;
import model.domain.Categoria;

public interface CategoriaDao {
	public Categoria salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
	public List<Categoria> getCategorias(Categoria categoria);
}