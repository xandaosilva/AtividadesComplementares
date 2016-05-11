package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="Lancamento")
public class Lancamento implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Integer codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataAtividade",nullable=false)
	private Date dataAtividade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataRegistro",nullable=false)
	private Date dataRegistro;
	
	@Column(name="horas",nullable=false)
	private Integer horas;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="aluno",referencedColumnName="cpf")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="administrador",referencedColumnName="siape")
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name="atividade",referencedColumnName="codigo")
	private Atividade atividade;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Lancamento(){}

	public Lancamento(Integer codigo, Date dataAtividade, Date dataRegistro, Integer horas, String descricao,
			Aluno aluno, Administrador administrador, Atividade atividade, Boolean ativo) {
		this.codigo = codigo;
		this.dataAtividade = dataAtividade;
		this.dataRegistro = dataRegistro;
		this.horas = horas;
		this.descricao = descricao;
		this.aluno = aluno;
		this.administrador = administrador;
		this.atividade = atividade;
		this.ativo = ativo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataAtividade() {
		return dataAtividade;
	}

	public void setDataAtividade(Date dataAtividade) {
		this.dataAtividade = dataAtividade;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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
		Lancamento other = (Lancamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lancamento [codigo=" + codigo + ", dataAtividade=" + dataAtividade + ", dataRegistro=" + dataRegistro
				+ ", horas=" + horas + ", descricao=" + descricao + ", ativo=" + ativo + "]";
	}
}