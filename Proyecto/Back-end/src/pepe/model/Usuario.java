package pepe.model;

public class Usuario extends Persona{
	
	private String mensajeBaneo;
	private Estado estado;

	public Usuario(String nombre, String apellidos, String contrase�a, String email, String avatar, Rol rol) {
		super(nombre, apellidos, contrase�a, email, avatar, rol);
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
