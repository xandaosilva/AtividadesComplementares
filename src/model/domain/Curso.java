package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Curso")
public class Curso implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome",unique=true,nullable=false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name="CursoModalidade",
	joinColumns=@JoinColumn(name="curso"),
	inverseJoinColumns=@JoinColumn(name="modalidade"))
	private List<Modalidade> modalidades;
	
	@OneToMany(mappedBy="curso")
	private List<Ppc> ppcs;
	
	@ManyToMany
	@JoinTable(name="AdministradorCurso",
	joinColumns=@JoinColumn(name="curso"),
	inverseJoinColumns=@JoinColumn(name="administrador"))
	private List<Administrador> administradores;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Curso(){
	}

	
	
	public Curso(Integer codigo, String nome, List<Modalidade> modalidades, List<Ppc> ppcs,
			List<Administrador> administradores, Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.modalidades = modalidades;
		this.ppcs = ppcs;
		this.administradores = administradores;
		this.ativo = ativo;
	}

	public boolean validar(){
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlTransient
	public List<Modalidade> getModalidades() {
		return modalidades;
	}

	public void setModalidades(List<Modalidade> modalidades) {
		this.modalidades = modalidades;
	}

	@XmlTransient
	public List<Ppc> getPpcs() {
		return ppcs;
	}

	public void setPpcs(List<Ppc> ppcs) {
		this.ppcs = ppcs;
	}

	@XmlTransient
	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", ativo=" + ativo + "]";
	}
}