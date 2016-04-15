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
@Table(name="Categoria")
public class Categoria implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Column(name="nome",unique=true,nullable=false)
	private String nome;
	
	@Column(name="porcentagemDaCategoria",nullable=false)
	private Double porcentagemDaCategoria;
	
	@Column(name="porcentagemPorAtividade",nullable=false)
	private Double porcentagemPorAtividade;
	
	@Column(name="atividadesPorSemestre",nullable=false)
	private Integer atividadesPorSemestre;
	
	@Column(name="observacoes",nullable=false)
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(name="modalidade",referencedColumnName="codigo")
	private Modalidade modalidade;
	
	@OneToMany(mappedBy="categoria")
	private List<Atividade> atividades;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Categoria(){
	}

	public Categoria(Integer codigo, String nome, Double porcentagemDaCategoria,Double porcentagemPorAtividade, 
			Integer atividadesPorSemestre,String observacoes, Modalidade modalidade,List<Atividade> atividades, 
			Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.porcentagemDaCategoria = porcentagemDaCategoria;
		this.porcentagemPorAtividade = porcentagemPorAtividade;
		this.atividadesPorSemestre = atividadesPorSemestre;
		this.observacoes = observacoes;
		this.modalidade = modalidade;
		this.atividades = atividades;
		this.ativo = ativo;
	}

	public Double calcularHoraMaximaAproveitadaPorCategoria(Ppc ppc){
		return ((this.porcentagemDaCategoria * (ppc.getCargaHoraria()/100.0)));
	}
	
	public Double calcularHorasAproveitadasPorAtividade(Ppc ppc){
		return (calcularHoraMaximaAproveitadaPorCategoria(ppc)/this.atividadesPorSemestre);
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPorcentagemDaCategoria() {
		return porcentagemDaCategoria;
	}

	public void setPorcentagemDaCategoria(Double porcentagemDaCategoria) {
		this.porcentagemDaCategoria = porcentagemDaCategoria;
	}

	public Double getPorcentagemPorAtividade() {
		return porcentagemPorAtividade;
	}

	public void setPorcentagemPorAtividade(Double porcentagemPorAtividade) {
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
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [codigo=" + codigo + ", nome=" + nome + ", porcentagemDaCategoria=" + porcentagemDaCategoria
				+ ", porcentagemPorAtividade=" + porcentagemPorAtividade + ", atividadesPorSemestre="
				+ atividadesPorSemestre + ", observacoes=" + observacoes + ", ativo=" + ativo + "]";
	}
}