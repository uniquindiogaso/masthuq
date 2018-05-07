package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;

import co.edu.uniquindio.compiladores.frontend.lexico.Token;

public class TablaSimbolos {
	private ArrayList<Variable> tabla;

	public TablaSimbolos() {
		tabla = new ArrayList<>();
	}

	/**
	 * Metodo auxiliar que permite obtener una variable del listado de la Tabla
	 * de Simbolos
	 * 
	 * @param token
	 * @return
	 */
	private Variable obtenerVariable(String token) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				return v;
			}
		}
		return null;
	}

	/**
	 * Comprobar en la tabla de simbolos si existe una variable
	 * definida/matriculada
	 * 
	 * @param token
	 * @return
	 */
	public boolean existe(String token) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprobar que una variable tenga valor definido
	 * 
	 * @param token
	 * @return
	 */
	public boolean tieneValor(String token) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				return v.getValor() != null ? true : false;
			}
		}
		return false;
	}
	
	

	/**
	 * Comprobar que dos tokens sean del mismo tipo
	 * 
	 * @param token1
	 * @param token2
	 * @return
	 */
	public boolean compatibles(String token1, String token2) {
		// TODO determinar si es necesario capturar si llega null
		return (obtenerVariable(token1).getTipo().equals(obtenerVariable(token2)));
	}

	/**
	 * De acuerdo al tipo de dato de un token comprobar que operaciones logicas
	 * se pueden realizar con el.
	 * 
	 * @param token1
	 * @param token2
	 * @param operador
	 * @return
	 */
	public boolean operadorPermitido(String token1, String token2, String operador) {
		if (!compatibles(token1, token2)) {
			return false;
		}

		// Como ambas se supone son del mismo tipo
		Variable t = obtenerVariable(token1);

		if (t.getTipo().equals("Cadena")) {
			return (operador.equals("==") || operador.equals("!="));
		} else {
			// Partiendo de que solo se tienen restricciones con el cadena ...
			// si es un Numero no se restringe nada.
			return true;
		}

	}
	
	//TODO - Revisar que estos metodos para facilitarle trabajo a JAVACC	
	
	/**
	 * FAcilitar el agregado de token a la tabla y evitar sintaxis en javaCC
	 * @param token
	 * @param lexema
	 * @param valor
	 * @param tipo
	 */
	public void agregar(String token, Token lexema, Object valor, String tipo){
		//tabla.add(new Variable(token, lexema, valor, tipo));
		if(!existe(lexema.image)) {
			tabla.add(new Variable(lexema.image,lexema,null,tipo));
		  }else {
			//aca reportar error
			 System.out.println("Error Agregando " + token + " ya esta definido");
		  }
	}
	
	/**
	 * Validaciones semanticas que se ocurren en el momento de usar una sentencia imprimir
	 * @param token
	 */
	public void validoUsar(Token token){
		boolean existe = existe(token.image);
		boolean valor = tieneValor(token.image);
		
		if (!existe){
			//agregar a tabla de Errores
			System.out.println(token.image + " no esta definida");
		}
		
		if (!valor){
			//agregar a tabla de Errores
		}	System.out.println("Para usar " + token.image + " debe tener un valor");
	}
	
	public void validoAsignar(Token token){
		boolean existe = existe(token.image);
		if(!existe){
			//agregar a tabla de errores
			System.out.println(token.image + " no esta definida");
		}else{
			//asignar valor aca.
		}
	}
	
	public void prueba(Token t){
		//t.
	}
	
	
	
	
	

	

}
