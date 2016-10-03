package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.AtividadeDao;
import model.domain.Atividade;
import model.service.AtividadeService;

public class AtividadeServiceImpl implements AtividadeService {

	@Inject
	private AtividadeDao atividadeDao;
	
	@Override
	public List<Atividade> getAtividades(Atividade atividade){
		return atividadeDao.getAtividades(atividade);
	}
	
	@Override
	public List<Atividade> getAtividadesAtivas(){
		return atividadeDao.getAtividadesAtivas();
	}
	
	@Override
	@Transactional
	public Atividade salvar(Atividade atividade){
		return atividadeDao.salvar(atividade);
	}
	
	@Override
	@Transactional
	public void atualizar(Atividade atividade){
		atividadeDao.atualizar(atividade);
	}
}