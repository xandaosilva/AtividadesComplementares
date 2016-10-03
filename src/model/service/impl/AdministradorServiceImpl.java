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
	public List<Administrador> getAdministradoresAtivos(){
		return administradorDao.getAdministradoresAtivos();
	}
	
	@Override
	@Transactional
	public Administrador salvar(Administrador administrador){
		return administradorDao.salvar(administrador);
	}
	
	@Override
	@Transactional
	public void atualizar(Administrador administrador){
		administradorDao.atualizar(administrador);
	}
}