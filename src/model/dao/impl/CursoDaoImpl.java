package model.dao.impl;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.CursoDao;
import model.domain.Ativo;
import model.domain.Curso;

public class CursoDaoImpl implements CursoDao{
	
	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Curso salvar(Curso curso){
		entityManager.persist(curso);
		return curso;
	}
	
	@Override
	public void atualizar(Curso curso){
		salvar(entityManager.merge(curso));
	}
	
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
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Curso> getCursosAtivos(){
		StringBuilder hql = new StringBuilder("from Curso c where c.ativo like :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("ativo",Ativo.ATIVO);
		return query.getResultList();
	}
}