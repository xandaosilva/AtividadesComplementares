package model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Atividade")
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@NotNull(message="preencha o nome")
	@Size(min=5,max=40,message="o nome deve conter entre 5 e 40 caracteres .")
	@Column(name="nome")
	private String nome;
	
	@NotNull(message="preencha a descricao")
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="quantidadeDeAtividadesPorSemestre")
	private Integer quantidadeDeAtividadesPorSemestre;
	
	@NotNull(message="preencha a porcentagem da atividade")
	@Min(1)
	@Max(100)
	@Column(name="porcentagem")
	private Integer porcentagem;
	
	@NotNull(message="preencha a porcentagem aproveitada por atividade")
	@Min(1)
	@Max(100)
	@Column(name="porcentagemAproveitadaPorAtividade")
	private Integer porcentagemAproveitadaPorAtividade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="ativo")
	private Ativo ativo;
	
	@ManyToOne
	@JoinColumn(name="modalidade",referencedColumnName="codigo")
	private Modalidade modalidade;
	
	@OneToMany(mappedBy="atividade")
	private List<Lancamento> lancamentos;
	
	public Atividade(){}

	public Atividade(Integer codigo, String nome, String descricao, Integer quantidadeDeAtividadesPorSemestre,
			Integer porcentagem, Integer porcentagemAproveitadaPorAtividade, Ativo ativo, Modalidade modalidade,
			List<Lancamento> lancamentos) {
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		if(quantidadeDeAtividadesPorSemestre == null){
			this.quantidadeDeAtividadesPorSemestre = Integer.MAX_VALUE;
		}
		else{
			this.quantidadeDeAtividadesPorSemestre = quantidadeDeAtividadesPorSemestre;
		}
		this.porcentagem = porcentagem;
		this.porcentagemAproveitadaPorAtividade = porcentagemAproveitadaPorAtividade;
		this.ativo = ativo;
		this.modalidade = modalidade;
		this.lancamentos = lancamentos;
	}

	private Map<String,List<Lancamento>> getMapa(List<Lancamento> lancamentos){
		Map<String,List<Lancamento>> mapaAtividades = new LinkedHashMap<>();
		for (Lancamento lancamento: lancamentos) {
			if (mapaAtividades.containsKey(lancamento.getSemestreAtividade())) {
				mapaAtividades.get(lancamento.getSemestreAtividade()).add(lancamento);
			} else {
				List<Lancamento> lista = new ArrayList<>();
				lista.add(lancamento);
				mapaAtividades.put(lancamento.getSemestreAtividade(), lista);
			}
		}
		return mapaAtividades;
	}
	
	private Integer calcularAtividadesPorSemestre(List<Lancamento> lancamentosSemestre, Integer horasMaximaAproveitadas,Integer horasMaximaPorSemestre) {
		Collections.sort(lancamentosSemestre,new HorasComparator());
		Integer quantidadeAtividadesRealizadas = 0;
		for (Lancamento lancamento: lancamentosSemestre) {
			quantidadeAtividadesRealizadas++;
			if (quantidadeAtividadesRealizadas > horasMaximaPorSemestre) {
				return horasMaximaAproveitadas;
			}
			Integer horas = lancamento.getHorasLancamento();
			int aproveitamento = horas;
			if (horas > horasMaximaPorSemestre) {
				aproveitamento = horasMaximaPorSemestre;				
			} 
			if (aproveitamento > horasMaximaAproveitadas) {
				aproveitamento = horasMaximaAproveitadas;
			}
			horasMaximaAproveitadas = horasMaximaAproveitadas - aproveitamento;
			lancamento.setHorasAproveitadas(aproveitamento);			
		}
		return horasMaximaAproveitadas;
	}
	
	public void calcularHorasPorAtividade(List<Lancamento> lancamentos){
		if(lancamentos.size() == 0){
			return;
		}
		Aluno aluno = lancamentos.get(0).getAluno();
		Integer horasMinima = aluno.getTurma().getPpc().getCargaHoraria();
		Integer horasMaximaAproveitadas = new Double(((horasMinima*porcentagem)/100)).intValue();
		Integer horasMaximaPorSemestre = new Double((horasMaximaAproveitadas*porcentagemAproveitadaPorAtividade)/100).intValue();
		Collections.sort(lancamentos,new SemestreComparator());
		Map<String,List<Lancamento>> atividadesPorSemestre = getMapa(lancamentos);
		for(String semestre : atividadesPorSemestre.keySet()){
			List<Lancamento> lancamentosSemestre = atividadesPorSemestre.get(semestre);
			Integer aproveitamento = calcularAtividadesPorSemestre(lancamentosSemestre,horasMaximaAproveitadas,horasMaximaPorSemestre);
			horasMaximaAproveitadas = horasMaximaAproveitadas - aproveitamento;
			if(horasMaximaAproveitadas <= 0){
				break;
			}
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getQuantidadeDeAtividadesPorSemestre() {
		return quantidadeDeAtividadesPorSemestre;
	}

	public void setQuantidadeDeAtividadesPorSemestre(Integer quantidadeDeAtividadesPorSemestre) {
		this.quantidadeDeAtividadesPorSemestre = quantidadeDeAtividadesPorSemestre;
	}

	public Integer getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Integer getPorcentagemAproveitadaPorAtividade() {
		return porcentagemAproveitadaPorAtividade;
	}

	public void setPorcentagemAproveitadaPorAtividade(Integer porcentagemAproveitadaPorAtividade) {
		this.porcentagemAproveitadaPorAtividade = porcentagemAproveitadaPorAtividade;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@XmlTransient
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
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
		Atividade other = (Atividade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atividade [codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao
				+ ", quantidadeDeAtividadesPorSemestre=" + quantidadeDeAtividadesPorSemestre + ", porcentagem="
				+ porcentagem + ", porcentagemAproveitadaPorAtividade=" + porcentagemAproveitadaPorAtividade
				+ ", ativo=" + ativo + "]";
	}
}