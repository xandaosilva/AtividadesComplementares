package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.LancamentoDao;
import model.domain.Ativo;
import model.domain.Lancamento;

public class LancamentoDaoImpl implements LancamentoDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	@Override
	public Lancamento salvar(Lancamento lancamento){
		entityManager.persist(lancamento);
		return lancamento;
	}
	
	@Override
	public void atualizar(Lancamento lancamento){
		salvar(entityManager.merge(lancamento));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> getLancamentos(Lancamento lancamento){
		StringBuilder hql = new StringBuilder("from Lancamento l where 1 = 1");
		if(lancamento.getCodigo() != null)
			hql.append("and l.codigo = :codigo");
		Query query = entityManager.createQuery(hql.toString());
		if(lancamento.getCodigo() != null)
			query.setParameter("codigo",lancamento.getCodigo());
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> getLancamentosAtivos(){
		StringBuilder hql = new StringBuilder("from Lancamento l where and l.ativo like :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("ativo",Ativo.ATIVO);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> getLancamentosPorAluno(int codigo){
		StringBuilder hql = new StringBuilder(" from Lancamento l where l.aluno.codigo = :codigo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("codigo", codigo);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> getLancamentosAtivosPorAluno(int codigo){
		StringBuilder hql = new StringBuilder(" from Lancamento l where l.aluno.codigo = :codigo and l.ativo = :ativo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("codigo", codigo);
		query.setParameter("ativo", Ativo.ATIVO);
		return query.getResultList();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Lancamento> getLancamentosPorAdministrador(int codigo){
		StringBuilder hql = new StringBuilder(" from Lancamento l where l.administrador.codigo = :codigo");
		Query query = entityManager.createQuery(hql.toString());
		query.setParameter("codigo", codigo);
		return query.getResultList();
	}
	
	@Override
	public void atualizarLancamentosCalculados(List<Lancamento> lancamentos){
		for(Lancamento aux : lancamentos){
			atualizar(aux);
		}
	}
}