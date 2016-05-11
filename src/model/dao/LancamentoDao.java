package model.dao;

import java.util.*;
import model.domain.Lancamento;

public interface LancamentoDao {
	public Lancamento salvar(Lancamento lancamento);
	public void atualizar(Lancamento lancamento);
	public List<Lancamento> getLancamentos(Lancamento lancamento);
}