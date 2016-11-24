package model.dao;

import java.util.*;
import model.domain.Atividade;

public interface AtividadeDao {
	Atividade salvar(Atividade atividade);
	void atualizar(Atividade atividade);
	List<Atividade> getAtividades(Atividade atividade);
	List<Atividade> getAtividadesAtivas();
}