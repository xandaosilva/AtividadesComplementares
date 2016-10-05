package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Administrador")
@PrimaryKeyJoinColumn(name="codigo")
public class Administrador extends Usuario {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull(message="preencha o siape")
	@Size(min=5,max=20,message="o siape deve conter entre 5 e 20 caracteres .")
	@Column(name="siape")
	private String siape;
	
	@OneToMany(mappedBy="administrador")
	private List<Lancamento> lancamentos;
	
	@OneToMany(mappedBy="administrador")
	private List<Curso> cursos;
	
	public Administrador(){}

	public Administrador(Integer codigo, String nome, String email, String senha, String siape, Ativo ativo, String observacoes, 
			 List<Lancamento> lancamentos, List<Curso> cursos) {
		super(codigo, nome, email, senha, observacoes, ativo);
		this.siape = siape;
		this.lancamentos = lancamentos;
		this.cursos = cursos;
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

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@Override
	public String toString() {
		return "Administrador [siape=" + siape + ", lancamentos=" + lancamentos + ", cursos=" + cursos + "]";
	}
}