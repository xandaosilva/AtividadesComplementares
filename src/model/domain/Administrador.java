package model.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name="Administrador")
public class Administrador extends Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="siape",unique=true,nullable=false)
	private Long siape;
	
	@Column(name="atividades")
	@OneToMany(mappedBy="administrador")
	private List<Atividade> atividades;
	
	public Administrador(){
	}

	public Administrador(Long codigo, String nome, String login, String senha,
			String observacoes, Boolean ativo,Long siape,List<Atividade> atividades) {
		super(codigo, nome, login, senha, observacoes, ativo);
		this.siape = siape;
		this.atividades = atividades;
	}

	public Long getSiape() {
		return siape;
	}

	public void setSiape(Long siape) {
		this.siape = siape;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((siape == null) ? 0 : siape.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrador other = (Administrador) obj;
		if (siape == null) {
			if (other.siape != null)
				return false;
		} else if (!siape.equals(other.siape))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrador [siape=" + siape + "]";
	}
}