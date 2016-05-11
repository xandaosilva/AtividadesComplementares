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
	
	@Override
	public Atividade salvar(Atividade categoria){
		entityManager.persist(categoria);
		return categoria;
	}
	
	@Override
	public void atualizar(Atividade categoria){
		salvar(entityManager.merge(categoria));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Atividade> getAtividades(Atividade atividade){
		StringBuilder hql = new StringBuilder("from Atividade a where 1 = 1");
		
		if(atividade.getCodigo() != null)
			hql.append("and a.codigo = :codigo");
		if(atividade.getNome() != null && !atividade.getNome().equals(""))
			hql.append("and a.nome like :nome");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if(atividade.getCodigo() != null)
			query.setParameter("codigo",atividade.getCodigo());
		if(atividade.getNome() != null && !atividade.getNome().equals(""))
			query.setParameter("nome","%"+atividade.getNome()+"%");
		
		return query.getResultList();
	}
}
