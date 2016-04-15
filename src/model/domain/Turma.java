package model.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Turma")
public class Turma implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="semestre",nullable=false)
	private Date semestre;
	
	@ManyToOne
	@JoinColumn(name="ppc",referencedColumnName="codigo")
	private Ppc ppc;
	
	@OneToMany(mappedBy="turma")
	private List<Aluno> alunos;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Turma(){
	}

	public Turma(Integer codigo, Date semestre, Ppc ppc, List<Aluno> alunos,Boolean ativo) {
		this.codigo = codigo;
		this.semestre = semestre;
		this.ppc = ppc;
		this.alunos = alunos;
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

	public Date getSemestre() {
		return semestre;
	}

	public void setSemestre(Date semestre) {
		this.semestre = semestre;
	}

	public Ppc getPpc() {
		return ppc;
	}

	public void setPpc(Ppc ppc) {
		this.ppc = ppc;
	}

	@XmlTransient
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
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
		Turma other = (Turma) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", semestre=" + semestre + ", ativo=" + ativo + "]";
	}
}