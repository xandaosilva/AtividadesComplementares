package model.dao;

import java.util.*;
import model.domain.Ppc;

public interface PpcDao {
	public Ppc salvar(Ppc ppc);
	public void atualizar(Ppc ppc);
	public List<Ppc> getPpcs(Ppc ppc);
}