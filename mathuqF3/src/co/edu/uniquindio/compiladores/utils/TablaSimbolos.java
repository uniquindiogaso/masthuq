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
				return v.getValor();
			}
		}
		System.out.println("*** No se encontro valor para " + token + " ***");
		return false;
	}

	public void actualizarValor(String token) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				v.setValor(true);
			}
		}
	}

	/**
	 * Comprobar que dos tokens sean del mismo tipo
	 * 
	 * @param token1
	 * @param token2
	 * @return
	 */
	public String AritCompatibles(String tipo1, String tipo2) {

		// System.out.println("(AritCompatibles) Tipo1: " + tipo1 + " Tipo2: " +
		// tipo2);

		if (tipo1 != "null" && tipo2 != "null") {
			if (tipo1.equals("Numero") && tipo2.equals("Numero")) {
				return "Numero";
			}
		}

		//
		if (!tipo1.equals("null")) {
			return tipo1;
		}

		//
		if (!tipo2.equals("null")) {
			return tipo2;
		}

		return "none";
	}

	/**
	 * De acuerdo al tipo de dato de un token comprobar que operaciones logicas
	 * se pueden realizar con el.
	 * 
	 * @param tipoToken1
	 * @param tipoToken2
	 * @param operador
	 * @return
	 */
	public boolean operadorPermitido(String tipoToken1, String tipoToken2, String operador) {

		boolean iguales = tipoToken1.equals(tipoToken2);

		if (iguales) {

			if (tipoToken1.equals("Cadena")) {
				if (!operador.equals("==") || !operador.equals("!=")) {
					// aca reportar error - Operador no es compatible con Cadena
					System.out.println("OperadorPermitido? para tipos " + tipoToken1 + " con operador " + operador);
				}
			} else if (tipoToken1.equals("Numero")) {
				// Partiendo de que solo se tienen restricciones con el cadena
				// ...
				// si es un Numero no se restringe nada.
				return true;
			}

			return false;

		} else {
			// aca reportar error - operandos no son compatibles
			System.out.println("Condicionadores no compatibles ");
		}

		return false;

	}

	// TODO - Revisar que estos metodos para facilitarle trabajo a JAVACC

	/**
	 * FAcilitar el agregado de token a la tabla y evitar sintaxis en javaCC
	 * 
	 * @param token
	 * @param lexema
	 * @param valor
	 * @param tipo
	 */
	public void agregar(String token, Token lexema, boolean valor, String tipo) {
		// tabla.add(new Variable(token, lexema, valor, tipo));
		if (!existe(lexema.image)) {
			tabla.add(new Variable(lexema.image, lexema, false, tipo));
		} else {
			// aca reportar error
			System.out.println("Error Agregando " + token + " ya esta definido");
		}
	}

	/**
	 * Validaciones semanticas que se ocurren en el momento de usar una
	 * sentencia imprimir
	 * 
	 * @param token
	 * @param accion
	 *            imprimir | asignar
	 * @return
	 */
	public boolean validoUsar(Token token, String accion) {
		boolean existe = existe(token.image);
		boolean valor = tieneValor(token.image);

		if (!existe) {
			// agregar a tabla de Errores
			System.out.println(token.image + " no esta definida");
		}

		if (!valor) {
			if (!accion.equals("asignar")) {
				// agregar a tabla de Errores
				System.out.println("Para usar " + token.image + " debe tener un valor ACCION = " + accion);
			}
		}

		return existe && valor;
	}

	public String obtenerTipo(Token t) {
		// System.out.println("obtenerTipo para " + t.image );
		if (existe(t.image)) {
			for (Variable v : tabla) {
				if (v.getToken().equals(t.image)) {
					return v.getTipo();
				}
			}
		}
		return "null";
	}

	public void validoAsignar(Token token, String tipo) {
		boolean existe = existe(token.image);
		boolean tipoValido = obtenerTipo(token).equals(tipo) && !tipo.equals("null");
		if (!existe) {
			// agregar a tabla de errores
			System.out.println(token.image + " no esta definida");
		}
		if (!tipoValido) {
			// agregar a tabla de errores
			System.out.println(token.image + "  tiene un tipo no valido " + tipo);
		}

		if (existe && tipoValido) {
			actualizarValor(token.image);
		}
	}

	public ArrayList<Variable> getTabla() {
		return tabla;
	}

}
