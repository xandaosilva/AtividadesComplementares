package model.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
	
	@NotNull(message="preencha a data da atividade")
	@Column(name="dataAtividade")
	private Date dataAtividade;
	
	@NotNull(message="preencha a data do lancamento")
	@Column(name="dataLancamento")
	private Date dataRegistro;
	
	@NotNull(message="preencha as horas do lancamento")
	@Column(name="horasLancamento")
	private Integer horasLancamento;
	
	@NotNull
	@Column(name="horasAproveitadas")
	private Integer horasAproveitadas;
	
	@NotNull(message="preencha a descricao")
	@Column(name="descricao")
	private String descricao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="ativo")
	private Ativo ativo;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name="instituicao")
	private Instituicao instituicao;
	
	@ManyToOne
	@JoinColumn(name="aluno",referencedColumnName="codigo")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="administrador",referencedColumnName="codigo")
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name="atividade",referencedColumnName="codigo")
	private Atividade atividade;
	
	public Lancamento(){}

	public Lancamento(Integer codigo, Date dataAtividade, Date dataRegistro, Integer horasLancamento,
			Integer horasAproveitadas, String descricao, Ativo ativo, Instituicao instituicao, Aluno aluno,
			Administrador administrador, Atividade atividade) {
		this.codigo = codigo;
		this.dataAtividade = dataAtividade;
		this.dataRegistro = dataRegistro;
		this.horasLancamento = horasLancamento;
		this.horasAproveitadas = horasAproveitadas;
		this.descricao = descricao;
		this.ativo = ativo;
		this.instituicao = instituicao;
		this.aluno = aluno;
		this.administrador = administrador;
		this.atividade = atividade;
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

	public Integer getHorasLancamento() {
		return horasLancamento;
	}

	public void setHorasLancamento(Integer horasLancamento) {
		this.horasLancamento = horasLancamento;
	}

	public Integer getHorasAproveitadas() {
		return horasAproveitadas;
	}

	public void setHorasAproveitadas(Integer horasAproveitadas) {
		this.horasAproveitadas = horasAproveitadas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Ativo getAtivo() {
		return ativo;
	}

	public void setAtivo(Ativo ativo) {
		this.ativo = ativo;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
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
				+ ", horasLancamento=" + horasLancamento + ", horasAproveitadas=" + horasAproveitadas + ", descricao="
				+ descricao + ", ativo=" + ativo + ", instituicao=" + instituicao + "]";
	}
}