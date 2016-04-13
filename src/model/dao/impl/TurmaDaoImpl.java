package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.TurmaDao;
import model.domain.Turma;

public class TurmaDaoImpl implements TurmaDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.TurmaDao#salvar(model.domain.Turma)
	 */
	@Override
	public Turma salvar(Turma turma){
		entityManager.persist(turma);
		return turma;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TurmaDao#atualizar(model.domain.Turma)
	 */
	@Override
	public void atualizar(Turma turma){
		salvar(entityManager.merge(turma));
	}
	
	/* (non-Javadoc)
	 * @see model.dao.TurmaDao#getTurmas(model.domain.Turma)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Turma> getTurmas(Turma turma){
		StringBuilder hql = new StringBuilder("from Turma t where 1 = 1");
		
		if(turma.getCodigo() != null)
			hql.append("and t.codigo = :codigo");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(turma.getCodigo() != null)
			query.setParameter("codigo",turma.getCodigo());
		
		return query.getResultList();
	}
}
