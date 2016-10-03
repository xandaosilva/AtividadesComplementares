package model.dao;

import java.util.*;
import model.domain.Administrador;

public interface AdministradorDao {
	public Administrador salvar(Administrador administrador);
	public void atualizar(Administrador administrador);
	public List<Administrador> getAdministradores(Administrador administrador);
	List<Administrador> getAdministradoresAtivos();
}