

public class variable {
	

	String nombre;
	String tipo;
	Token tokenvalor;
	Boolean asignacion;
	
	
	public variable(String nombre, String tipo, String ambito) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
	
	}
	
	/**
	 * @return the valor
	 */
	public Token getTokenvalor() {
		return tokenvalor;
	}

	/**
	 * @param valor the valor to set
	 */
	public  void setTokenvalor(Token valor) {
		this.tokenvalor = valor;
	}

	/**
	 * @return the asignacion
	 */
	public Boolean getAsignacion() {
		return asignacion;
	}

	/**
	 * @param asignacion the asignacion to set
	 */
	public void setAsignacion(Boolean asignacion) {
		this.asignacion = asignacion;
	}

	public variable()
	{
		
	}
	
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "dato [nombre=" + nombre + ", tipo=" + tipo + ", tokenvalor=" + tokenvalor + ", asignacion=" + asignacion
				+ "]";
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
