package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.ModalidadeDao;
import model.domain.Modalidade;
import model.service.ModalidadeService;

public class ModalidadeServiceImpl implements ModalidadeService {

	@Inject
	private ModalidadeDao modalidadeDao;
	
	/* (non-Javadoc)
	 * @see model.service.ModalidadeService#getModalidades(model.domain.Modalidade)
	 */
	@Override
	public List<Modalidade> getModalidades(Modalidade modalidade){
		return modalidadeDao.getModalidades(modalidade);
	}
	
	/* (non-Javadoc)
	 * @see model.service.ModalidadeService#salvar(model.domain.Modalidade)
	 */
	@Override
	@Transactional
	public Modalidade salvar(Modalidade modalidade){
		return modalidadeDao.salvar(modalidade);
	}
	
	/* (non-Javadoc)
	 * @see model.service.ModalidadeService#atualizar(model.domain.Modalidade)
	 */
	@Override
	@Transactional
	public void atualizar(Modalidade modalidade){
		modalidadeDao.atualizar(modalidade);
	}
}