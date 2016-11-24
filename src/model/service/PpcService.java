package model.service;

import java.util.*;
import model.domain.Ppc;

public interface PpcService {
	List<Ppc> getPpcs(Ppc ppc);
	List<Ppc> getPpcsAtivos();
	Ppc salvar(Ppc ppc);
	void atualizar(Ppc ppc);
}