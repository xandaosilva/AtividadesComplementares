package model.dao;

import java.util.*;
import model.domain.Atividade;

public interface AtividadeDao {
	public Atividade salvar(Atividade atividade);
	public void atualizar(Atividade atividade);
	public List<Atividade> getAtividades(Atividade atividade);
}