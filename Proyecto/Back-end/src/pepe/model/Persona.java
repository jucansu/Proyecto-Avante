package pepe.model;

public abstract class Persona {
	
	private String nombre, apellidos, contrase�a, email, avatar;
	private Rol rol;
	
	public Persona(String nombre, String apellidos, String contrase�a, String email, String avatar, Rol rol) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.contrase�a = contrase�a;
		this.email = email;
		this.avatar = avatar;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}


}
