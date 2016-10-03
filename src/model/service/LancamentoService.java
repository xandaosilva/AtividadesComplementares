package model.service;

import java.util.*;
import model.domain.Lancamento;

public interface LancamentoService {
	public List<Lancamento> getLancamentos(Lancamento lancamento);
	public List<Lancamento> getLancamentosAtivos();
	public Lancamento salvar(Lancamento lancamento);
	public void atualizar(Lancamento lancamento);
}