package model.dao;

import java.util.List;

import model.domain.Lancamento;

public interface LancamentoDao {
	Lancamento salvar(Lancamento lancamento);
	void atualizar(Lancamento lancamento);
	List<Lancamento> getLancamentos(Lancamento lancamento);
	List<Lancamento> getLancamentosAtivos();
	List<Lancamento> getLancamentosPorAluno(int codigo);
	List<Lancamento> getLancamentosAtivosPorAluno(int codigo);
	List<Lancamento> getLancamentosPorAdministrador(int codigo);
	void atualizarLancamentosCalculados(List<Lancamento> lancamentos);
}