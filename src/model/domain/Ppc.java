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
@Table(name="Ppc")
public class Ppc implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="codigo")
	private Integer codigo;
	
	@NotNull(message="preencha a versao")
	@Size(min=10,max=40,message="a versao deve conter entre 10 e 40 caracteres .")
	@Column(name="versao")
	private String versao;
	
	@NotNull(message="preencha a carga horaria")
	@Column(name="cargaHoraria")
	private Integer cargaHoraria;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="ativo")
	private Ativo ativo;
	
	@ManyToOne
	@JoinColumn(name="curso",referencedColumnName="codigo")
	private Curso curso;
	
	@OneToMany(mappedBy="ppc")
	private List<Turma> turmas;
	
	public Ppc(){}

	public Ppc(Integer codigo, String versao, Integer cargaHoraria, Ativo ativo, Curso curso, List<Turma> turmas) {
		this.codigo = codigo;
		this.versao = versao;
		this.cargaHoraria = cargaHoraria;
		this.ativo = ativo;
		this.curso = curso;
		this.turmas = turmas;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@XmlTransient
	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
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
		Ppc other = (Ppc) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ppc [codigo=" + codigo + ", versao=" + versao + ", cargaHoraria=" + cargaHoraria + ", ativo=" + ativo
				+ "]";
	}
}