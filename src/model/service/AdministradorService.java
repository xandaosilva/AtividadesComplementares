package model.service;

import java.util.*;
import model.domain.Administrador;

public interface AdministradorService {
	public List<Administrador> getAdministradores(Administrador administrador);
	public Administrador salvar(Administrador administrador);
	public void atualizar(Administrador administrador);
}