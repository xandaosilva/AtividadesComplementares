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
@Table(name="Atividade")
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome",unique=true,nullable=false)
	private String nome;
	
	@Column(name="porcentagemDaCategoria",nullable=false)
	private Integer porcentagemDaCategoria;
	
	@Column(name="porcentagemPorAtividade",nullable=false)
	private Integer porcentagemPorAtividade;
	
	@Column(name="atividadesPorSemestre",nullable=false)
	private Integer atividadesPorSemestre;
	
	@Column(name="observacoes",nullable=false)
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name="modalidade",referencedColumnName="codigo")
	private Modalidade modalidade;
	
	@OneToMany(mappedBy="atividade")
	private List<Lancamento> lancamentos;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Atividade(){
	}

	public Atividade(Integer codigo, String nome, Integer porcentagemDaCategoria, Integer porcentagemPorAtividade,
			Integer atividadesPorSemestre, String observacoes, Modalidade modalidade, List<Lancamento> lancamentos,
			Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.porcentagemDaCategoria = porcentagemDaCategoria;
		this.porcentagemPorAtividade = porcentagemPorAtividade;
		this.atividadesPorSemestre = atividadesPorSemestre;
		this.observacoes = observacoes;
		this.modalidade = modalidade;
		this.lancamentos = lancamentos;
		this.ativo = ativo;
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

	public Integer getPorcentagemDaCategoria() {
		return porcentagemDaCategoria;
	}

	public void setPorcentagemDaCategoria(Integer porcentagemDaCategoria) {
		this.porcentagemDaCategoria = porcentagemDaCategoria;
	}

	public Integer getPorcentagemPorAtividade() {
		return porcentagemPorAtividade;
	}

	public void setPorcentagemPorAtividade(Integer porcentagemPorAtividade) {
		this.porcentagemPorAtividade = porcentagemPorAtividade;
	}

	public Integer getAtividadesPorSemestre() {
		return atividadesPorSemestre;
	}

	public void setAtividadesPorSemestre(Integer atividadesPorSemestre) {
		this.atividadesPorSemestre = atividadesPorSemestre;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		return "Atividade [codigo=" + codigo + ", nome=" + nome + ", porcentagemDaCategoria=" + porcentagemDaCategoria
				+ ", porcentagemPorAtividade=" + porcentagemPorAtividade + ", atividadesPorSemestre="
				+ atividadesPorSemestre + ", observacoes=" + observacoes + ", ativo=" + ativo + "]";
	}
}