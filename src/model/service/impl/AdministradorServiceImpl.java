package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.AdministradorDao;
import model.domain.Administrador;
import model.service.AdministradorService;

public class AdministradorServiceImpl implements AdministradorService {

	@Inject
	private AdministradorDao administradorDao;
		
	/* (non-Javadoc)
	 * @see model.service.AdministradorService#getAdministradores(model.domain.Administrador)
	 */
	@Override
	public List<Administrador> getAdministradores(Administrador administrador){
		return administradorDao.getAdministradores(administrador);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AdministradorService#salvar(model.domain.Administrador)
	 */
	@Override
	@Transactional
	public Administrador salvar(Administrador administrador){
		return administradorDao.salvar(administrador);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AdministradorService#atualizar(model.domain.Administrador)
	 */
	@Override
	@Transactional
	public void atualizar(Administrador administrador){
		administradorDao.atualizar(administrador);
	}
}