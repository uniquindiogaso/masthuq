package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;
import java.util.HashMap;

import co.edu.uniquindio.compiladores.frontend.lexico.Token;

public class TablaSimbolos {
	private ArrayList<Variable> tabla;

	private ArrayList<Semantica> erroresSemanticos;

	public TablaSimbolos() {
		tabla = new ArrayList<>();
		erroresSemanticos = new ArrayList<>();
	}

	/**
	 * Auxiliares para determinar a que token se esta operando
	 * 
	 * @param t
	 * @param tipo
	 * @return
	 */
	public Variable var(Token t, String tipo) {
		return new Variable(t, tipo);
	}

	/**
	 * Auxiliares para determinar a que token se esta operando
	 * 
	 * @param tipo
	 * @return
	 */
	public Variable var(String tipo) {
		return new Variable(tipo);
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

	public void notificarError(String token, boolean error) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				v.setError(error);
			}
		}

	}

	public boolean verificarError(String token) {
		for (Variable v : tabla) {
			if (token.equals(v.getToken())) {
				return v.isError();
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
	public Variable AritCompatibles(Variable var1, Variable var2) {

		// System.out.println("(AritCompatibles) Tipo1: " + tipo1 + " Tipo2: " +
		// tipo2);

		if (var1 != null && var2 != null) {

			String tipo1 = var1.getTipo();
			String tipo2 = var2.getTipo();

			if (tipo1.equals("Numero") && tipo2.equals("Numero")) {
				return var("Numero");
			}

			if (tipo1.equals("Cadena")) {
				// aca reportar error - Operador no es compatible con Cadena
				// FIX - Comprobar que var1 sea variable ..
				System.out
						.println("No se pueden realizar operaciones matematicas con Cadenas " + var1.getLexema().image);
				erroresSemanticos.add(
						new Semantica(var1.getLexema(), "No se puede realizar operaciones matematicas con Cadenas"));
				return var("null");
			}

			if (tipo2.equals("Cadena")) {
				// aca reportar error - Operador no es compatible con Cadena
				// FIX - Comprobar que var1 sea variable ..
				System.out
						.println("No se pueden realizar operaciones matematicas con Cadenas " + var2.getLexema().image);
				erroresSemanticos.add(
						new Semantica(var2.getLexema(), "No se puede realizar operaciones matematicas con Cadenas"));
				return var("null");
			}

		}

		//
		if (var1 != null) {
			return var1;
		}

		//
		if (var2 != null) {
			return var2;
		}

		return null;
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
	public boolean operadorPermitido(Variable var1, Variable var2, Token ope) {

		String tipoToken1 = var1.getTipo();
		String tipoToken2 = var2.getTipo();
		String operador = ope.image;

		boolean iguales = tipoToken1.equals(tipoToken2);

		if (iguales) {

			if (tipoToken1.equals("Cadena")) {
				if (!operador.equals("==") && !operador.equals("!=")) {

					String t1 = "";
					String t2 = "";

					if (var1.isVar()) {
						t1 = var1.getLexema().image;
					}

					if (var2.isVar()) {
						t1 = var2.getLexema().image;
					}

					// aca reportar error - Operador no es compatible con Cadena
					System.out.println("Operador" + operador
							+ " no es compatible con Cadenas (No se pueden sumar peras con manzanas) " + t1 + " " + t2
							+ "" + ope.beginLine);

					erroresSemanticos.add(new Semantica(null, null,
							"Operador "
									+ " no es compatible con Cadenas.(No se pueden sumar peras con manzanas) Linea: "
									+ ope.beginLine));
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
			System.out.println("Condicionadores no compatibles para " + operador + " en linea " + ope.beginLine);

			String msjError = "Condicionadores no compatibles para operador: '" + operador + "'";

			if (var1.isVar() && var1.getLexema() != null) {
				System.out.println("para " + var1.getLexema().image + " : " + var1.getLexema().beginLine);
				msjError += " invalido : '" + var1.getLexema().image + "'";
			}
			if (var2.isVar() && var2.getLexema() != null) {
				System.out.println("para " + var2.getLexema().image + " : " + var2.getLexema().beginLine);
				msjError += " invalido : '" + var2.getLexema().image + "'";
			}

			erroresSemanticos.add(new Semantica(null, msjError + "  Linea: " + ope.beginLine));
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
			erroresSemanticos.add((new Semantica(lexema, "Ya esta definida. No se puede redefinir variables.")));
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

		// System.out.println("TOKEN A ANALIZAR " + token);
		// System.out.println("ACCION " + accion);

		if (!existe) {
			// agregar a tabla de Errores
			System.out.println(token.image + " no esta definida: " + token.beginLine);
			erroresSemanticos.add((new Semantica(token, "No esta definida")));
		}

		if (!valor) {
			// if (!accion.equals("asignar")) {
			// agregar a tabla de Errores
			System.out.println(
					"Para usar " + token.image + " debe tener un valor [ACCION = " + accion + "] : " + token.beginLine);
			erroresSemanticos.add((new Semantica(token,
					"Para usar variable debe tener un valor. No es posible usarla en accion " + accion)));
			notificarError(token.image,true);
			
			// }
		}else{
			notificarError(token.image, false);
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

	public void validoAsignar(Token token, Variable tipo) {

		boolean existe = existe(token.image);
		boolean tipoValido = false;
		boolean error= verificarError(token.image);
		// System.out.println("Variable para token " + token.image + " : var " +
		// tipo);

		if (tipo != null) {
			tipoValido = obtenerTipo(token).equals(tipo.getTipo());

			// System.out.println("Info " + tipo.getTipo());
			// System.out.println("Info " + tipo.getToken());
		}

		if (!existe) {
			// agregar a tabla de errores
			System.out.println(token.image + " no esta definida: " + token.beginLine);
			erroresSemanticos.add((new Semantica(token, "No esta definida")));
		}
		if (!tipoValido) {
			// agregar a tabla de errores
			System.out.println(
					token.image + "  no se le puede asignar un " + tipo.getTipo() + " linea " + token.beginLine);
			erroresSemanticos.add((new Semantica(token,
					"No se puede asignar un " + tipo.getTipo() + ", no corresponden los tipos.")));
		}

		if (existe && tipoValido&&!error) {
			actualizarValor(token.image);
		}
	}

	public ArrayList<Variable> getTabla() {
		return tabla;
	}

	public ArrayList<Semantica> getErroresSemanticos() {
		return erroresSemanticos;
	}

}
