package model.service;

import java.util.*;
import model.domain.Modalidade;

public interface ModalidadeService {
	public List<Modalidade> getModalidades(Modalidade modalidade);
	public Modalidade salvar(Modalidade modalidade);
	public void atualizar(Modalidade modalidade);
}