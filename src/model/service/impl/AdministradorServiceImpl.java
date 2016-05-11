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
		

	@Override
	public List<Administrador> getAdministradores(Administrador administrador){
		return administradorDao.getAdministradores(administrador);
	}
	
	@Override
	@Transactional
	public Administrador salvar(Administrador administrador){
		if(administrador.validar() == true)
			return administradorDao.salvar(administrador);
		else
			return null;
	}
	
	@Override
	@Transactional
	public void atualizar(Administrador administrador){
		if(administrador.validar() == true)
			administradorDao.atualizar(administrador);
		else
			return;
	}
}