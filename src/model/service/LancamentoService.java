package model.service;

import java.util.*;
import model.domain.Lancamento;

public interface LancamentoService {
	List<Lancamento> getLancamentos(Lancamento lancamento);
	List<Lancamento> getLancamentosAtivos();
	Lancamento salvar(Lancamento lancamento);
	void atualizar(Lancamento lancamento);
}