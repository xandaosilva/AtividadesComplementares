package model.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
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
	
	@OneToMany(mappedBy="aluno",fetch=FetchType.EAGER)
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

	private Map<Atividade,List<Lancamento>> getMapa() {
		Map<Atividade,List<Lancamento>> mapaAtividades = new LinkedHashMap<>();
		for (Lancamento lancamento: lancamentos) {
			if (mapaAtividades.containsKey(lancamento.getAtividade())) {
				mapaAtividades.get(lancamento.getAtividade()).add(lancamento);
			} else {
				List<Lancamento> lista = new ArrayList<>();
				lista.add(lancamento);
				mapaAtividades.put(lancamento.getAtividade(), lista);
			}
		}
		return mapaAtividades;
	}
	
	public void calcularAtividades() {
		Map<Atividade,List<Lancamento>> mapaAtividades = getMapa();
		for (Atividade aux: mapaAtividades.keySet()) {
			List<Lancamento> lancamentos = mapaAtividades.get(aux);			
			aux.calcularHorasPorAtividade(lancamentos);
		}
	}
	
	public int calcularHorasAproveitadas(List<Lancamento> lancamentos){
		Integer horas = 0;
		this.calcularAtividades();
		for(Lancamento aux : lancamentos){
			horas = horas + aux.getHorasAproveitadas();
		}
		return horas;
	}

	public int calcularHorasDentroDaInstituicao(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos){
			if(aux.getInstituicao().equals(Instituicao.IFTM)){
				horasAux = horasAux + aux.getHorasAproveitadas();
			}
		}
		return horasAux;
	}
	
	public int calcularHorasForaDaInstituicao(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos){
			if(aux.getInstituicao().equals(Instituicao.OUTROS)){
				horasAux = horasAux + aux.getHorasAproveitadas();
			}
		}
		return horasAux;
	}
	
	public int somarTotalHoras(List<Lancamento> lancamentos){
		int horasAux = 0;
		for(Lancamento aux : lancamentos){
			horasAux = horasAux + aux.getHorasLancamento();
		}
		return horasAux;
	}
	
	public void aprovarAluno(){
		if(this.horasAproveitadas >= this.turma.getPpc().getCargaHoraria()){
			this.setAprovado(Aprovado.APROVADO);
		}
		else{
			this.setAprovado(Aprovado.NAO_APROVADO);
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