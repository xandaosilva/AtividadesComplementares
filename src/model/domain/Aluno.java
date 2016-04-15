package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Aluno")
@PrimaryKeyJoinColumn(name="usuario")
public class Aluno extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="cpf",unique=true,nullable=false)
	private String cpf;
	
	@Column(name="horas",nullable=false)
	private Double horas;
	
	@Column(name="totalHoras",nullable=false)
	private Double totalHoras;
	
	@ManyToOne
	@JoinColumn(name="turma",referencedColumnName="codigo")
	private Turma turma;
	
	@OneToMany(mappedBy="aluno")
	private List<Atividade> atividades;
	
	public Aluno(){
	}

	public Aluno(Integer codigo, String nome, String login, String senha, String observacoes, Boolean ativo, 
			String cpf, Double horas, Double totalHoras, Turma turma, List<Atividade> atividades) {
		super(codigo, nome, login, senha, observacoes, ativo);
		this.cpf = cpf;
		this.horas = horas;
		this.totalHoras = totalHoras;
		this.turma = turma;
		this.atividades = atividades;
	}

	public boolean verificarAprovacao(){
		if(this.horas >= this.turma.getPpc().getCargaHoraria())
			return true;
		else
			return false;
	}
	
	public double somarTotalHorasDoAluno(){
		for(Atividade aux : this.atividades)
			if(aux.getAtivo() == true)
				this.totalHoras = this.totalHoras + aux.getHoras();
		return this.totalHoras;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
		this.horas = horas;
	}

	public Double getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Double totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@XmlTransient
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [cpf=" + cpf + ", horas=" + horas + ", totalHoras=" + totalHoras + "]";
	}
}