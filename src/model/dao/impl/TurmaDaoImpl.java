package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.TurmaDao;
import model.domain.Ativo;
import model.domain.Turma;

public class TurmaDaoImpl implements TurmaDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Turma salvar(Turma turma){
		entityManager.persist(turma);
		return turma;
	}
	
	@Override
	public void atualizar(Turma turma){
		salvar(entityManager.merge(turma));
	}
	
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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Turma> getTurmasAtivas(){
		StringBuilder hql = new StringBuilder("from Turma t where t.ativo like :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("ativo",Ativo.ATIVO);
		return query.getResultList();
	}
}
