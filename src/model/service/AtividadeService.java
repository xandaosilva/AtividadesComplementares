package model.service;

import java.util.*;
import model.domain.Atividade;

public interface AtividadeService {
	List<Atividade> getAtividades(Atividade atividade);
	List<Atividade> getAtividadesAtivas();
	Atividade salvar(Atividade atividade);
	void atualizar(Atividade atividade);
}