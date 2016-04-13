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
@Table(name="Atividade")
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataAtividade",nullable=false)
	private Date dataAtividade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dataRegistro",nullable=false)
	private Date dataRegistro;
	
	@Column(name="horas",nullable=false)
	private Double horas;
	
	@Column(name="descricao")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="aluno",referencedColumnName="codigo")
	private Aluno aluno;
	
	@ManyToOne
	@JoinColumn(name="administrador",referencedColumnName="codigo")
	private Administrador administrador;
	
	@ManyToOne
	@JoinColumn(name="categoria",referencedColumnName="codigo")
	private Categoria categoria;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Atividade(){
	}

	public Atividade(Long codigo, Date dataAtividade, Date dataRegistro, Double horas, String descricao, 
			Aluno aluno, Administrador administrador, Categoria categoria, Boolean ativo) {
		this.codigo = codigo;
		this.dataAtividade = dataAtividade;
		this.dataRegistro = dataRegistro;
		this.horas = horas;
		this.descricao = descricao;
		this.aluno = aluno;
		this.administrador = administrador;
		this.categoria = categoria;
		this.ativo = ativo;
	}
	
	public double calcularHorasRegistradas(){
		return 0.0;
	}
	
	public boolean validar(){
		if(this.dataAtividade.after(this.dataRegistro)){
			if(this.horas > 0.0){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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

	public Double getHoras() {
		return horas;
	}

	public void setHoras(Double horas) {
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
		return "Atividade [codigo=" + codigo + ", dataAtividade=" + dataAtividade + ", dataRegistro=" + 
				dataRegistro + ", horas=" + horas + ", descricao=" + descricao + ", ativo=" + ativo + "]";
	}
}