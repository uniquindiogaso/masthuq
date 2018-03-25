package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;

import co.edu.uniquindio.compiladores.frontend.lexico.ParseException;

public class Impresion {
	
	ArrayList<Variable> variables;
	ArrayList<ParseException> errores;
	
	public static String ImprimirLexico(ArrayList<Variable> vars){
		//System.out.println(n + ") Linea:\u005ct"+nL+"\u005ctColumna:\u005ct"+nC+"\u005ctLexema:\u005ct\u005c""+lexema+"\u005c"\u005ct"+"Token:\u005ct"+token);
		String res = "";
		for(Variable v : vars){
			res+=  v.getNum() + ") Linea:\u005ct"+v.getLexema().beginLine+"\u005ctColumna:\u005ct"+v.getLexema().beginColumn+"\tLexema:\t\t"+ v.getLexema().image +"\t\t Token:\t"+v.getToken(); 
		}
		return res;
	}
	
	public void test(){
		//variables.add(new Variable(num, token, pieza));
		  ParseException error = null;
		  
		  String msj = "Linea " +  error.currentToken.beginLine  + " Columna " + error.currentToken.beginColumn + " Encontrado " + error.tokenImage[0];
		
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
	
	
	
	
	

}
