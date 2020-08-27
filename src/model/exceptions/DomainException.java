package model.exceptions;

public class DomainException extends  RuntimeException{
    // Exception é serialazible entao setando o padrao cria a linha abaixo
	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) {
		super(msg);
	}
	

}
