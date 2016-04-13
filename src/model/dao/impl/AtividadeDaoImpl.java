package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.AtividadeDao;
import model.domain.Atividade;

public class AtividadeDaoImpl implements AtividadeDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.AtividadeDao#salvar(model.domain.Atividade)
	 */
	@Override
	public Atividade salvar(Atividade atividade){
		entityManager.persist(atividade);
		return atividade;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.AtividadeDao#atualizar(model.domain.Atividade)
	 */
	@Override
	public void atualizar(Atividade atividade){
		salvar(entityManager.merge(atividade));
	}
	
	/* (non-Javadoc)
	 * @see model.dao.AtividadeDao#getAtividades(model.domain.Atividade)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Atividade> getAtividades(Atividade atividade){
		StringBuilder hql = new StringBuilder("from Atividade a where 1 = 1");
		
		if(atividade.getCodigo() != null)
			hql.append("and a.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(atividade.getCodigo() != null)
			query.setParameter("codigo",atividade.getCodigo());
		
		return query.getResultList();
	}
}
