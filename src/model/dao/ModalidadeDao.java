package model.dao;

import java.util.*;
import model.domain.Modalidade;

public interface ModalidadeDao {
	Modalidade salvar(Modalidade modalidade);
	void atualizar(Modalidade modalidade);
	List<Modalidade> getModalidades(Modalidade modalidade);
	List<Modalidade> getModalidadesAtivas();
}