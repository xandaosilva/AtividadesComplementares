package model.dao;

import java.util.*;
import model.domain.Administrador;

public interface AdministradorDao {
	Administrador salvar(Administrador administrador);
	void atualizar(Administrador administrador);
	List<Administrador> getAdministradores(Administrador administrador);
	List<Administrador> getAdministradoresAtivos();
}