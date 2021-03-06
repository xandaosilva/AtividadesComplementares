package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.ModalidadeDao;
import model.domain.Ativo;
import model.domain.Modalidade;

public class ModalidadeDaoImpl implements ModalidadeDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Modalidade salvar(Modalidade modalidade){
		entityManager.persist(modalidade);
		return modalidade;
	}
	
	@Override
	public void atualizar(Modalidade modalidade){
		salvar(entityManager.merge(modalidade));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Modalidade> getModalidades(Modalidade modalidade){
		StringBuilder hql = new StringBuilder("from Modalidade m where 1 = 1");
		if(modalidade.getCodigo() != null)
			hql.append("and m.codigo = :codigo");
		if(modalidade.getNome() != null && !modalidade.getNome().equals(""))
			hql.append("and m.nome like :nome");
		Query query = entityManager.createQuery(hql.toString());
		if(modalidade.getCodigo() != null)
			query.setParameter("codigo",modalidade.getCodigo());
		if(modalidade.getNome() != null && !modalidade.getNome().equals(""))
			query.setParameter("nome","%"+modalidade.getNome()+"%");
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Modalidade> getModalidadesAtivas(){
		StringBuilder hql = new StringBuilder("from Modalidade m where m.ativo like :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("ativo",Ativo.ATIVO);
		return query.getResultList();
	}
}