package model.dao;

import java.util.*;
import model.domain.Modalidade;

public interface ModalidadeDao {
	public Modalidade salvar(Modalidade modalidade);
	public void atualizar(Modalidade modalidade);
	public List<Modalidade> getModalidades(Modalidade modalidade);
	public List<Modalidade> getModalidadesAtivas();
}