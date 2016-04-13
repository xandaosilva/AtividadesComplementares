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
	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#getCategorias(model.domain.Categoria)
	 */
	@Override
	public List<Categoria> getCategorias(Categoria categoria){
		return categoriaDao.getCategorias(categoria);
	}
	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#salvar(model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Categoria salvar(Categoria categoria){
		return categoriaDao.salvar(categoria);
	}
	
	/* (non-Javadoc)
	 * @see model.service.CategoriaService#atualizar(model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Categoria categoria){
		categoriaDao.atualizar(categoria);
	}
}