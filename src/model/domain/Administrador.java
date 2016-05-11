package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Administrador")
@PrimaryKeyJoinColumn(name="codigo")
public class Administrador extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="siape",unique=true,nullable=false)
	private String siape;
	
	@OneToMany(mappedBy="administrador")
	private List<Lancamento> lancamentos;
	
	@OneToMany(mappedBy="administrador")
	private List<Curso> cursos;
	
	public Administrador(){
	}

	public Administrador(Integer codigo, String nome, String login, String senha, String observacoes, Boolean ativo,
			String siape, List<Lancamento> lancamentos, List<Curso> cursos) {
		super(codigo, nome, login, senha, observacoes, ativo);
		this.siape = siape;
		this.lancamentos = lancamentos;
		this.cursos = cursos;
	}
	
	public boolean validar(){
		if(super.validar() == true){
			if(!this.getSiape().equals("")){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}

	@XmlTransient
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@XmlTransient
	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCurso(List<Curso> curso) {
		this.cursos = curso;
	}

	@Override
	public String toString() {
		return "Administrador [siape=" + siape + ", toString()=" + super.toString() + "]";
	}
}