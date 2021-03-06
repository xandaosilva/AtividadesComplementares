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
	public List<Lancamento> getLancamentosAtivos(){
		return lancamentoDao.getLancamentosAtivos();
	}
	
	@Override
	public List<Lancamento> getLancamentosAtivosPorAluno(int codigo){
		return lancamentoDao.getLancamentosAtivosPorAluno(codigo);
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
	
	@Override
	@Transactional
	public void atualizarLancamentosCalculados(List<Lancamento> lancamentos){
		lancamentoDao.atualizarLancamentosCalculados(lancamentos);
	}
}