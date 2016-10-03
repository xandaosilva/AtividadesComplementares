package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Aluno")
@PrimaryKeyJoinColumn(name="codigo")
public class Aluno extends Usuario {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="preencha o cpf")
	@Size(min=11,max=11,message="cpf deve conter 11 digitos")
	@Column(name="cpf",unique=true)
	private String cpf;
	
	@NotNull(message="preencha o total de horas")
	@Column(name="totalHoras")
	private Integer totalHoras;
	
	@NotNull(message="preencha o total de horas aproveitadas")
	@Column(name="horasAproveitadas")
	private Integer horasAproveitadas;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="aprovado")
	private Aprovado aprovado;
	
	@ManyToOne
	@JoinColumn(name="turma",referencedColumnName="codigo")
	private Turma turma;
	
	@OneToMany(mappedBy="aluno")
	private List<Lancamento> lancamentos;
	
	public Aluno(){}

	public Aluno(Integer codigo, String nome, String login, String senha, String observacoes, Ativo ativo, String cpf,
			Integer totalHoras, Integer horasAproveitadas, Aprovado aprovado, Turma turma,
			List<Lancamento> lancamentos) {
		super(codigo, nome, login, senha, observacoes, ativo);
		this.cpf = cpf;
		this.totalHoras = totalHoras;
		this.horasAproveitadas = horasAproveitadas;
		this.aprovado = aprovado;
		this.turma = turma;
		this.lancamentos = lancamentos;
	}

	public int calcularHorasPorAtividade(Atividade atividade){
		return 0;
	}
	
	public int calcularHorasPorSemestre(Atividade atividade){
		return 0;
	}
	
	public int calcularHorasDentroDaInstituicao(){
		return 0;
	}
	
	public int calcularHorasForaDaInstituicao(){
		return 0;
	}
	
	public int calcularTotalHorasAproveitadas(){
		return 0;
	}
	
	public int calcularTotalHoras(){
		return 0;
	}
	
	public void aprovarAluno(){
		return;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTotalHoras() {
		return totalHoras;
	}

	public void setTotalHoras(Integer totalHoras) {
		this.totalHoras = totalHoras;
	}

	public Integer getHorasAproveitadas() {
		return horasAproveitadas;
	}

	public void setHorasAproveitadas(Integer horasAproveitadas) {
		this.horasAproveitadas = horasAproveitadas;
	}

	public Aprovado getAprovado() {
		return aprovado;
	}

	public void setAprovado(Aprovado aprovado) {
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
		return "Aluno [cpf=" + cpf + ", totalHoras=" + totalHoras + ", horasAproveitadas=" + horasAproveitadas
				+ ", aprovado=" + aprovado + "]";
	}
}