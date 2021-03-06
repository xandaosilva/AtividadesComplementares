package model.service;

import java.util.*;
import model.domain.Lancamento;

public interface LancamentoService {
	List<Lancamento> getLancamentos(Lancamento lancamento);
	List<Lancamento> getLancamentosAtivos();
	List<Lancamento> getLancamentosAtivosPorAluno(int codigo);
	Lancamento salvar(Lancamento lancamento);
	void atualizar(Lancamento lancamento);
	void atualizarLancamentosCalculados(List<Lancamento> lancamentos);
}