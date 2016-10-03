package model.domain;

public enum Ativo {

	ATIVO("ATIVO"),INATIVO("INATIVO");
	
	private String ativo;

	private Ativo(String ativo) {
		this.ativo = ativo;
	}
	
	public String getAtivo(){
		return this.ativo;
	}
}
