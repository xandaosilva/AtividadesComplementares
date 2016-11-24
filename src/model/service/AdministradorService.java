package model.service;

import java.util.*;
import model.domain.Administrador;

public interface AdministradorService {
	List<Administrador> getAdministradores(Administrador administrador);
	List<Administrador> getAdministradoresAtivos();
	Administrador salvar(Administrador administrador);
	void atualizar(Administrador administrador);
}