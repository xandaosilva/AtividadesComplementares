package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name="Modalidade")
public class Modalidade implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="codigo")
	private Long codigo;
	
	@Column(name="nome",unique=true,nullable=false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name="CursoModalidade",joinColumns=@JoinColumn(name="modalidade"),inverseJoinColumns=@JoinColumn(name="codigo"))
	private List<Curso> cursos;
	
	@OneToMany(mappedBy="modalidade")
	private List<Categoria> categorias;
	
	@Column(name="ativo",columnDefinition="TINYINT(1)",nullable=false)
	private Boolean ativo;
	
	public Modalidade(){
	}

	public Modalidade(Long codigo, String nome, List<Curso> cursos,List<Categoria> categorias, Boolean ativo) {
		this.codigo = codigo;
		this.nome = nome;
		this.cursos = cursos;
		this.categorias = categorias;
		this.ativo = ativo;
	}
	
	public boolean validar(){
		return true;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@XmlTransient
	public List<Curso> getCurso() {
		return cursos;
	}

	public void setCurso(List<Curso> cursos) {
		this.cursos = cursos;
	}

	@XmlTransient
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Modalidade other = (Modalidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Modalidade [codigo=" + codigo + ", nome=" + nome + ", ativo=" + ativo + "]";
	}
}