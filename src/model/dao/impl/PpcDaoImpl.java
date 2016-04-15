package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.PpcDao;
import model.domain.Ppc;

public class PpcDaoImpl implements PpcDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Ppc salvar(Ppc ppc){
		entityManager.persist(ppc);
		return ppc;
	}
	
	@Override
	public void atualizar(Ppc ppc){
		salvar(entityManager.merge(ppc));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Ppc> getPpcs(Ppc ppc){
		StringBuilder hql = new StringBuilder("from Ppc p where 1 = 1");
		
		if(ppc.getCodigo() != null)
			hql.append("and p.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(ppc.getCodigo() != null)
			query.setParameter("codigo",ppc.getCodigo());
		
		return query.getResultList();
	}
}
