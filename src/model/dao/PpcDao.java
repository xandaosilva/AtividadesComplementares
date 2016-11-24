package model.dao;

import java.util.*;
import model.domain.Ppc;

public interface PpcDao {
	Ppc salvar(Ppc ppc);
	void atualizar(Ppc ppc);
	List<Ppc> getPpcs(Ppc ppc);
	List<Ppc> getPpcsAtivos();
}