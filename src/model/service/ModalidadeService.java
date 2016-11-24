package model.service;

import java.util.*;
import model.domain.Modalidade;

public interface ModalidadeService {
	List<Modalidade> getModalidades(Modalidade modalidade);
	List<Modalidade> getModalidadesAtivas();
	Modalidade salvar(Modalidade modalidade);
	void atualizar(Modalidade modalidade);
}