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
	
	/* (non-Javadoc)
	 * @see model.service.AtividadeService#getAtividades(model.domain.Atividade)
	 */
	@Override
	public List<Atividade> getAtividades(Atividade atividade){
		return atividadeDao.getAtividades(atividade);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AtividadeService#salvar(model.domain.Atividade)
	 */
	@Override
	@Transactional
	public Atividade salvar(Atividade atividade){
		return atividadeDao.salvar(atividade);
	}
	
	/* (non-Javadoc)
	 * @see model.service.AtividadeService#atualizar(model.domain.Atividade)
	 */
	@Override
	@Transactional
	public void atualizar(Atividade atividade){
		atividadeDao.atualizar(atividade);
	}
}