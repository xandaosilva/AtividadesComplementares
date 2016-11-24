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

	public Aluno(Integer codigo, String nome, String email, String senha, Integer totalHoras, Integer horasAproveitadas, 
			Aprovado aprovado, String cpf, Ativo ativo, Turma turma, String observacoes, List<Lancamento> lancamentos) {
		super(codigo, nome, email, senha, observacoes, ativo);
		this.cpf = cpf;
		this.totalHoras = totalHoras;
		this.horasAproveitadas = horasAproveitadas;
		this.aprovado = aprovado;
		this.turma = turma;
		this.lancamentos = lancamentos;
	}
//
//	public int calcularHorasPorAtividade(Atividade atividade){
//		int horasAux = 0;
//		for(Lancamento aux : this.lancamentos){
//			if(aux.getAtividade().equals(atividade) && aux.getAtivo().equals(Ativo.ATIVO)){
//				horasAux = horasAux + aux.getHorasAproveitadas();
//			}
//		}
//		return horasAux;
//	}
//	
//	public int calcularHorasPorSemestre(Atividade atividade){
//		return 0;
//	}
//	
//	public int calcularHorasDentroDaInstituicao(){
//		int horasAux = 0;
//		for(Lancamento aux : this.lancamentos){
//			if(aux.getInstituicao().equals(Instituicao.IFTM) && aux.getAtivo().equals(Ativo.ATIVO)){
//				horasAux = horasAux + aux.getHorasAproveitadas();
//			}
//		}
//		return horasAux;
//	}
//	
//	public int calcularHorasForaDaInstituicao(){
//		int horasAux = 0;
//		for(Lancamento aux : this.lancamentos){
//			if(aux.getInstituicao().equals(Instituicao.OUTROS) && aux.getAtivo().equals(Ativo.ATIVO)){
//				horasAux = horasAux + aux.getHorasAproveitadas();
//			}
//		}
//		return horasAux;
//	}
//	
//	public int calcularTotalHorasAproveitadas(){
//		int horasAux = 0;
//		for(Lancamento aux : this.lancamentos){
//			if(aux.getAtivo().equals(Ativo.ATIVO)){
//				horasAux = horasAux + aux.getHorasAproveitadas();
//			}
//		}
//		return horasAux;
//	}
	
	public void ordenarLancamentosPorData(List<Lancamento> lancamentos){
		return;
	}
	
	public int calcularAproveitamento(List<Lancamento> lancamentos){
		return 0;
	}
	
	public int calcularHorasDentroDaInstituicao(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos)
			if(aux.getInstituicao().equals(Instituicao.IFTM))
				horasAux = horasAux + aux.getHorasAproveitadas();
		return horasAux;
	}
	
	public int calcularHorasForaDaInstituicao(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos)
			if(aux.getInstituicao().equals(Instituicao.OUTROS))
				horasAux = horasAux + aux.getHorasAproveitadas();
		return horasAux;
	}
	
	public int calcularTotalHoras(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos)
			horasAux = horasAux + aux.getHorasLancamento();
		return horasAux;
	}
	
	public void aprovarAluno(){
		if(this.horasAproveitadas >= this.turma.getPpc().getCargaHoraria()){
			this.setAprovado(Aprovado.APROVADO);
		}
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