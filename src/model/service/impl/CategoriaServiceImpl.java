package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.CategoriaDao;
import model.domain.Categoria;
import model.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService {

	@Inject
	private CategoriaDao categoriaDao;
	
	@Override
	public List<Categoria> getCategorias(Categoria categoria){
		return categoriaDao.getCategorias(categoria);
	}
	
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria){
		return categoriaDao.salvar(categoria);
	}
	
	@Override
	@Transactional
	public void atualizar(Categoria categoria){
		categoriaDao.atualizar(categoria);
	}
}