package co.edu.uniquindio.compiladores.utils;

import java.util.ArrayList;

public class TablaSimbolos {
	private ArrayList<Variable> tabla;
	
	public TablaSimbolos() {
		tabla = new ArrayList<>();
	}
	
	private  Variable obtenerVariable(String token){
		return null;
	}
	
	public boolean existe(String token){
		for(Variable v : tabla){
			if (token.equals(v.getToken())){
				return true;
			}
		}
		return false;
	}
	
	public boolean tieneValor(String token){
		for(Variable v : tabla){
			if (token.equals(v.getToken())){
				return v.getValor() != null ? true : false;
			}
		}
		return false;
	}
	
	public boolean compatibles(String token1 , String token2){
		
		return false;
	}

}
