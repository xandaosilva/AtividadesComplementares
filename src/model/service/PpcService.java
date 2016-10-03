package model.service;

import java.util.*;
import model.domain.Ppc;

public interface PpcService {
	public List<Ppc> getPpcs(Ppc ppc);
	public List<Ppc> getPpcsAtivos();
	public Ppc salvar(Ppc ppc);
	public void atualizar(Ppc ppc);
}