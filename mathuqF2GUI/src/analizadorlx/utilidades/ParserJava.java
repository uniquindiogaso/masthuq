package analizadorlx.utilidades;

import java.util.HashMap;

public class ParserJava {

    private HashMap<String, String> java;
    private HashMap<String, String> javaCast;

    public ParserJava() {
        java = new HashMap<>();
        javaCast = new HashMap<>();
        configParser();
        configParserCast();
    }

    private void configParserCast() {
        javaCast.put("Leer", " Integer.parseInt(br.readLine");
        javaCast.put("[", "(");
        javaCast.put("]", "))");
    }

    private void configParser() {
        java.put(".", ";\n");
        java.put("@", "+");
        java.put("[", "(");
        java.put("]", ")");
        java.put("Numero", "int ");
        java.put("Cadena", "String ");
        java.put("Escribir", "System.out.println");
        java.put("Leer", " br.readLine");
        java.put("Si", "if (");
        java.put("Entonces", ") {");
        java.put("Sino", "} else {");
        java.put("Finsi", "}");
    }

    public HashMap<String, String> getJava() {
        return java;
    }

    public String toJava(String lexema) {
        if (!java.containsKey(lexema)) {
            return lexema;
        }
        return java.get(lexema);
    }

    /**
     * Caso Especial de Parser... ya que aca se tiene que hacer una conversion
     * de tipo cuando es un Entero.
     *
     * @param lexema
     * @return representacion en lenguaje java.
     */
    public String toJavaCase(String lexema) {
        if (!javaCast.containsKey(lexema)) {
            return lexema;
        }
        return javaCast.get(lexema);
    }

}
