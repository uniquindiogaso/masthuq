package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;

import co.edu.uniquindio.compiladores.frontend.lexico.ParseException;
import co.edu.uniquindio.compiladores.frontend.lexico.SimpleNode;

public class Impresion {

	/**
	 * Convertir Listado de Variables en un String tabulado
	 * @param vars listado de Variables
	 * @return Analizador lexico formato cadena
	 */
	public static String ImprimirLexico(ArrayList<Variable> vars) {
		// System.out.println(n + ")
		// Linea:\u005ct"+nL+"\u005ctColumna:\u005ct"+nC+"\u005ctLexema:\u005ct\u005c""+lexema+"\u005c"\u005ct"+"Token:\u005ct"+token);
		String res = "";
		for (Variable v : vars) {
			res += v.getNum() + ") Linea:\u005ct" + v.getLexema().beginLine + "\u005ctColumna:\u005ct"
					+ v.getLexema().beginColumn + "\tLexema:\t\t" + v.getLexema().image + "\t\t Token:\t" + v.getToken()
					+ "\n";
		}
		return res;
	}

	public static String imprimirErrores(ArrayList<ParseException> errores) {
		String res = "";
		int num = 0;
		for (ParseException error : errores) {
			num++;
			res += num+") Error Sintáctico encontrado en Linea: " + error.currentToken.beginLine + " Columna: " + error.currentToken.next.beginColumn
					+ " Encontrado: \"" + error.currentToken.next + "\" Esperado: " + tokensEsperados(error).toString() + "\n";
		}
		return res;
	}

	/**
	 * Metodo aux para traducir los mensajes del Parse a cristiano
	 * @param error 
	 * @return
	 */
	private static StringBuffer tokensEsperados(ParseException error) {
		StringBuffer esperado = new StringBuffer();
		int tMaximo = 0;
		for (int i = 0; i < error.expectedTokenSequences.length; i++) {
			if (tMaximo < error.expectedTokenSequences[i].length) {
				tMaximo = error.expectedTokenSequences[i].length;
			}
			for (int j = 0; j < error.expectedTokenSequences[i].length; j++) {
				esperado.append(error.tokenImage[error.expectedTokenSequences[i][j]]).append(' ');
			}
			if (error.expectedTokenSequences[i][error.expectedTokenSequences[i].length - 1] != 0) {
				esperado.append("...");
			}
			// expected.append(eol).append(" ");
		}
		return esperado;
	}

}
