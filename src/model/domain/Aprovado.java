package model.domain;

public enum Aprovado {

	APROVADO("APROVADO"),NAO_APROVADO("NAO_APROVADO");
	
	private String aprovado;
	
	Aprovado(String aprovado){
		this.aprovado = aprovado;
	}
	
	public String getAprovado(){
		return this.aprovado;
	}
}