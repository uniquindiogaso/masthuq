package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;

import co.edu.uniquindio.compiladores.frontend.lexico.ParseException;
import co.edu.uniquindio.compiladores.frontend.lexico.SimpleNode;

public class Impresion {

	ArrayList<Variable> variables;
	ArrayList<ParseException> errores;
	private SimpleNode nodoPrincipal;

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
			res += num+") Error en Linea: " + error.currentToken.beginLine + " Columna: " + error.currentToken.endColumn
					+ " Encontrado: \"" + error.currentToken.next + "\" Esperado: " + tokensEsperados(error).toString() + "\n";
		}
		return res;
	}

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

	public void test() {
		// variables.add(new Variable(num, token, pieza));
		ParseException error = null;

		String msj = "Linea " + error.currentToken.beginLine + " Columna " + error.currentToken.beginColumn
				+ " Encontrado " + error.tokenImage[0];

	}

	public ArrayList<Variable> getVariables() {
		return variables;
	}

	public void setVariables(ArrayList<Variable> variables) {
		this.variables = variables;
	}

	public ArrayList<ParseException> getErrores() {
		return errores;
	}

	public void setErrores(ArrayList<ParseException> errores) {
		this.errores = errores;
	}

	public SimpleNode getNodoPrincipal() {
		return nodoPrincipal;
	}

	public void setNodoPrincipal(SimpleNode nodoPrincipal) {
		this.nodoPrincipal = nodoPrincipal;
	}

}
