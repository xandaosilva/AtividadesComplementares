package model.service.impl;

import java.util.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import model.dao.LancamentoDao;
import model.domain.Lancamento;
import model.service.LancamentoService;

public class LancamentoServiceImpl implements LancamentoService {
	
	@Inject
	private LancamentoDao lancamentoDao;
	
	@Override
	public List<Lancamento> getLancamentos(Lancamento lancamento){
		return lancamentoDao.getLancamentos(lancamento);
	}
	
	@Override
	@Transactional
	public Lancamento salvar(Lancamento lancamento){
		return lancamentoDao.salvar(lancamento);
	}
	
	@Override
	@Transactional
	public void atualizar(Lancamento lancamento){
		lancamentoDao.atualizar(lancamento);
	}
}