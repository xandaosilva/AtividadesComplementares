package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.PpcDao;
import model.domain.Ppc;
import model.service.PpcService;

public class PpcServiceImpl implements PpcService {

	@Inject
	private PpcDao ppcDao;
	
	@Override
	public List<Ppc> getPpcs(Ppc ppc){
		return ppcDao.getPpcs(ppc);
	}
	
	@Override
	@Transactional
	public Ppc salvar(Ppc ppc){
		return ppcDao.salvar(ppc);
	}
	
	@Override
	@Transactional
	public void atualizar(Ppc ppc){
		ppcDao.atualizar(ppc);
	}
}