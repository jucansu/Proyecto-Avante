package pepe.model;

public class Usuario extends Persona{
	
	private String mensajeBaneo;
	private Estado estado;

	public Usuario() {
		super();
	}

	public String getMensajeBaneo() {
		return mensajeBaneo;
	}

	public void setMensajeBaneo(String mensajeBaneo) {
		this.mensajeBaneo = mensajeBaneo;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
}
