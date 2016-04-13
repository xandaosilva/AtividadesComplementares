package model.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.dao.AdministradorDao;
import model.domain.Administrador;

public class AdministradorDaoImpl implements AdministradorDao {

	@PersistenceContext(unitName="AtividadePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see model.dao.AdministradorDao#salvar(model.domain.Administrador)
	 */
	@Override
	public Administrador salvar(Administrador administrador){
		entityManager.persist(administrador);
		return administrador;
	}
	
	/* (non-Javadoc)
	 * @see model.dao.AdministradorDao#atualizar(model.domain.Administrador)
	 */
	@Override
	public void atualizar(Administrador administrador){
		salvar(entityManager.merge(administrador));
	}
	
	/* (non-Javadoc)
	 * @see model.dao.AdministradorDao#getAdministradores(model.domain.Administrador)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Administrador> getAdministradores(Administrador administrador){
		StringBuilder hql = new StringBuilder("from Administrador a where 1 = 1");
		
		if(administrador.getCodigo() != null)
			hql.append("and a.codigo = :codigo");
		if(administrador.getNome() != null && !administrador.getNome().equals(""))
			hql.append("and a.nome like :nome");
		
		Query query = entityManager.createQuery(hql.toString());
		
		if (administrador.getCodigo() != null)
			query.setParameter("codigo",administrador.getCodigo());
		if (administrador.getNome() != null && !administrador.getNome().equals(""))
			query.setParameter("nome","%"+administrador.getNome()+"%");
		
		return query.getResultList();
	}
}
