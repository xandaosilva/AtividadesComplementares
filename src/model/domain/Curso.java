package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
		
	@ManyToOne
	@JoinColumn(name="administrador",referencedColumnName="siape")
	private Administrador administrador;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)")
	private Boolean ativo;
	
	@OneToMany(mappedBy="curso")
	private List<Ppc> ppcs;
	
	public Curso(){
	}

	public Curso(Integer codigo, String nome, Administrador administrador, Boolean ativo, List<Ppc> ppcs) {
		this.codigo = codigo;
		this.nome = nome;
		this.administrador = administrador;
		this.ativo = ativo;
		this.ppcs = ppcs;
	}
	
	public boolean validar(){
		if(this.getAdministrador().getCodigo() != null){
			if(this.getAdministrador().validar() == true){
				if(!this.getNome().equals("")){
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
		else{
			return false;
		}
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
	public List<Ppc> getPpcs() {
		return ppcs;
	}

	public void setPpcs(List<Ppc> ppcs) {
		this.ppcs = ppcs;
	}

	
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
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