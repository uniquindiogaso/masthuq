package co.edu.uniquindio.compiladores.utils;

import co.edu.uniquindio.compiladores.frontend.lexico.Token;

public class Semantica {
	
	private Token token;
	private Token token2;
	private String mensaje;
	
	public Semantica(Token token, String mensaje) {
		super();
		this.token = token;
		this.mensaje = mensaje;
	}
	
	

	public Semantica(Token token, Token token2, String mensaje) {
		super();
		this.token = token;
		this.token2 = token2;
		this.mensaje = mensaje;
	}



	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}



	public Token getToken2() {
		return token2;
	}



	public void setToken2(Token token2) {
		this.token2 = token2;
	}
	
	
	

}
