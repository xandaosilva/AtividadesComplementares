package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.AlunoDao;
import model.domain.Aluno;
import model.domain.Ativo;

public class AlunoDaoImpl implements AlunoDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Aluno salvar(Aluno aluno){
		entityManager.persist(aluno);
		return aluno;
	}
	
	@Override
	public void atualizar(Aluno aluno){
		salvar(entityManager.merge(aluno));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunos(Aluno aluno){
		StringBuilder hql = new StringBuilder("from Aluno a where 1 = 1");
		if(aluno.getCodigo() != null)
			hql.append(" and a.codigo = :codigo");
		if(aluno.getNome() != null && !aluno.getNome().equals(""))
			hql.append(" and a.nome like :nome");
		Query query = entityManager.createQuery(hql.toString());
		if(aluno.getCodigo() != null)
			query.setParameter("codigo",aluno.getCodigo());
		if(aluno.getNome() != null && !aluno.getNome().equals(""))
			query.setParameter("nome","%"+aluno.getNome()+"%");
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunosAtivos(){
		StringBuilder hql = new StringBuilder("from Aluno a where a.ativo like :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("ativo",Ativo.ATIVO);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> getAlunosPorTurma(int codigo){
		StringBuilder hql = new StringBuilder(" from Aluno a where a.turma = :codigo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("codigo", codigo);
		return query.getResultList();
	}
}