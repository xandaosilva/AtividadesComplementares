package model.service;

import java.util.*;
import model.domain.Categoria;

public interface CategoriaService {
	public List<Categoria> getCategorias(Categoria categoria);
	public Categoria salvar(Categoria categoria);
	public void atualizar(Categoria categoria);
}