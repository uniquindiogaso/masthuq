package co.edu.uniquindio.compiladores.utils;

import co.edu.uniquindio.compiladores.frontend.lexico.Token;

public class Variable {

	private int num;
	private String token;
	private Token lexema;
	private boolean valor;
	private String tipo;
	//Determinar si es una variable(sorry por este hardcore)
	private boolean var;
	private boolean error;
	
	public Variable(int num, String token, Token pieza) {
		super();
		this.num = num;
		this.token = token;
		this.lexema = pieza;
	}
	
	
	

	public Variable(String token, Token lexema, boolean valor, String tipo) {
		super();
		this.token = token;
		this.lexema = lexema;
		this.valor = valor;
		this.tipo = tipo;
	}


	public Variable(Token lexema, String tipo) {
		super();
		this.lexema = lexema;
		this.tipo = tipo;
		this.var = true;
	}


	public Variable(String tipo) {
		super();
		this.tipo = tipo;
		this.var = false;
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



	public boolean getValor() {
		return valor;
	}



	public void setValor(boolean valor) {
		this.valor = valor;
	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}




	public boolean isVar() {
		return var;
	}




	public void setVar(boolean var) {
		this.var = var;
	}




	public boolean isError() {
		return error;
	}




	public void setError(boolean error) {
		this.error = error;
	}




	@Override
	public String toString() {
		return "Variable [num=" + num + ", token=" + token + ", lexema=" + lexema + ", valor=" + valor + ", tipo="
				+ tipo + ", var=" + var + ", error=" + error + "]";
	}
	
	
	
	
	
	
	
}
