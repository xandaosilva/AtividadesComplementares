package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.CategoriaDao;
import model.domain.Categoria;

public class CategoriaDaoImpl implements CategoriaDao {
	
	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.CategoriaDao#salvar(model.domain.Categoria)
	 */
	@Override
	public Categoria salvar(Categoria categoria){
		entityManager.persist(categoria);
		return categoria;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.CategoriaDao#atualizar(model.domain.Categoria)
	 */
	@Override
	public void atualizar(Categoria categoria){
		salvar(entityManager.merge(categoria));
	}
	
	/* (non-Javadoc)
	 * @see model.dao.CategoriaDao#getCategorias(model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Categoria> getCategorias(Categoria categoria){
		StringBuilder hql = new StringBuilder("from Categoria c where 1 = 1");
		
		if(categoria.getCodigo() != null)
			hql.append("and c.codigo = :codigo");
		if(categoria.getNome() != null && !categoria.getNome().equals(""))
			hql.append("and c.nome like :nome");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(categoria.getCodigo() != null)
			query.setParameter("codigo",categoria.getCodigo());
		if(categoria.getNome() != null && !categoria.getNome().equals(""))
			query.setParameter("nome","%"+categoria.getNome()+"%");
		
		return query.getResultList();
	}
}
