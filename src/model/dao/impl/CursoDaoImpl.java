package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.CursoDao;
import model.domain.Curso;

public class CursoDaoImpl implements CursoDao{
	
	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.Curso#salvar(model.domain.Curso)
	 */
	/* (non-Javadoc)
	 * @see model.dao.CursoDao#salvar(model.domain.Curso)
	 */

	@Override
	public Curso salvar(Curso curso){
		entityManager.persist(curso);
		return curso;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Curso#atualizar(model.domain.Curso)
	 */
	/* (non-Javadoc)
	 * @see model.dao.CursoDao#atualizar(model.domain.Curso)
	 */

	@Override
	public void atualizar(Curso curso){
		salvar(entityManager.merge(curso));
	}
	
	/* (non-Javadoc)
	 * @see model.dao.Curso#getCursos(model.domain.Curso)
	 */
	/* (non-Javadoc)
	 * @see model.dao.CursoDao#getCursos(model.domain.Curso)
	 */

	@Override
	@SuppressWarnings("unchecked")
	public List<Curso> getCursos(Curso curso){
		StringBuilder hql = new StringBuilder("from Curso c where 1 = 1");
		
		if(curso.getCodigo() != null)
			hql.append("and c.codigo = :codigo");
		if(curso.getNome() != null && !curso.getNome().equals(""))
			hql.append("and c.nome like :nome");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(curso.getCodigo() != null)
			query.setParameter("codigo",curso.getCodigo());
		if(curso.getNome() != null && !curso.getNome().equals(""))
			query.setParameter("nome","%"+curso.getNome()+"%");
		
		return query.getResultList();
	}
}