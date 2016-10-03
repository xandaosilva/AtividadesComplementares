package model.domain;

public enum Instituicao {

	IFTM("IFTM"),OUTROS("OUTROS");
	
	private String instituicao;
	
	Instituicao(String instituicao){
		this.instituicao = instituicao;
	}
	
	public String getInstituicao(){
		return this.instituicao;
	}
}