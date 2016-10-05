package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
	
	@NotNull(message="preencha o nome")
	@Size(min=20,max=50,message="o nome deve conter entre 20 e 50 caracteres .")
	@Column(name="nome")
	private String nome;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="ativo")
	private Ativo ativo;
	
	@ManyToOne
	@JoinColumn(name="administrador",referencedColumnName="codigo")
	private Administrador administrador;
	
	@OneToMany(mappedBy="curso")
	private List<Ppc> ppcs;
	
	public Curso(){}

	public Curso(Integer codigo, String nome, Ativo ativo, Administrador administrador, List<Ppc> ppcs) {
		this.codigo = codigo;
		this.nome = nome;
		this.ativo = ativo;
		this.administrador = administrador;
		this.ppcs = ppcs;
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

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	@XmlTransient
	public List<Ppc> getPpcs() {
		return ppcs;
	}

	public void setPpcs(List<Ppc> ppcs) {
		this.ppcs = ppcs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativo == null) ? 0 : ativo.hashCode());
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
		if (ativo != other.ativo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", nome=" + nome + ", ativo=" + ativo + "]";
	}
}