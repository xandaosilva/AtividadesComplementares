package model.service;

import java.util.*;
import model.domain.Atividade;

public interface AtividadeService {
	public List<Atividade> getAtividades(Atividade atividade);
	public Atividade salvar(Atividade atividade);
	public void atualizar(Atividade atividade);
}