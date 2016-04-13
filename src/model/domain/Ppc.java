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

@XmlRootElement
@Entity
@Table(name="Ppc")
public class Ppc implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="cargaHoraria",nullable=false)
	private Double cargaHoraria;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataPpc",nullable=false)
	private Date dataPpc;
	
	@ManyToOne
	@JoinColumn(name="curso",referencedColumnName="codigo")
	private Curso curso;
	
	@OneToMany(mappedBy="ppc")
	private List<Turma> turmas;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Ppc(){
	}

	public Ppc(Long codigo, Double cargaHoraria, Date dataPpc, Curso curso,List<Turma> turmas, Boolean ativo) {
		this.codigo = codigo;
		this.cargaHoraria = cargaHoraria;
		this.dataPpc = dataPpc;
		this.curso = curso;
		this.turmas = turmas;
		this.ativo = ativo;
	}
	
	public boolean validar(){
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Date getDataPpc() {
		return dataPpc;
	}

	public void setDataPpc(Date dataPpc) {
		this.dataPpc = dataPpc;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
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
		return "Ppc [codigo=" + codigo + ", cargaHoraria=" + cargaHoraria + ", dataPpc=" + dataPpc + ", ativo=" + ativo
				+ "]";
	}
}