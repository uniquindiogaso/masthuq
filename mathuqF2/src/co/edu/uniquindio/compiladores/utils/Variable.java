package co.edu.uniquindio.compiladores.utils;

import co.edu.uniquindio.compiladores.frontend.lexico.Token;

public class Variable {

	private int num;
	private String token;
	private Token lexema;
	
	public Variable(int num, String token, Token pieza) {
		super();
		this.num = num;
		this.token = token;
		this.lexema = pieza;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Token getLexema() {
		return lexema;
	}

	public void setLexema(Token lexema) {
		this.lexema = lexema;
	}
	
}
