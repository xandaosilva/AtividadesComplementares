package model.domain;

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
@PrimaryKeyJoinColumn(name="codigo")
public class Aluno extends Usuario {
	
	private static final long serialVersionUID = 1L;

	@Column(name="cpf",unique=true,nullable=false)
	private String cpf;
	
	@Column(name="horas",nullable=false)
	private Integer horas;
	
	@Column(name="totalHoras",nullable=false)
	private Integer totalHoras;
	
	@Column(name="aprovado",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean aprovado;
	
	@ManyToOne
	@JoinColumn(name="turma",referencedColumnName="codigo")
	private Turma turma;
	
	@OneToMany(mappedBy="aluno")
	private List<Lancamento> lancamentos;
	
	public Aluno(){
	}

	public Aluno(Integer codigo, String nome, String login, String senha, String observacoes, Boolean ativo, String cpf,
			Integer horas, Integer totalHoras, Boolean aprovado, Turma turma, List<Lancamento> lancamentos) {
		super(codigo, nome, login, senha, observacoes, ativo);
		this.cpf = cpf;
		this.horas = horas;
		this.totalHoras = totalHoras;
		this.aprovado = aprovado;
		this.turma = turma;
		this.lancamentos = lancamentos;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Integer getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Integer totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	@XmlTransient
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	@Override
	public String toString() {
		return "Aluno [cpf=" + cpf + ", horas=" + horas + ", totalHoras=" + totalHoras + ", aprovado=" + aprovado
				+ ", toString()=" + super.toString() + "]";
	}
}