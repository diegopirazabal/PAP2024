package logica;

public class dataTypeUsuario {

	 private String nombre;
	 private String apellido;
	 private String nickname;
	 private String email;
	 private String fnacimiento;
	
	 public dataTypeUsuario(String nombre, String apellido, String nickname, String email, String fnacimiento) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nickname = nickname;
		this.email = email;
		this.fnacimiento = fnacimiento;
	 }

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getFnacimiento() {
		return fnacimiento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFnacimiento(String fnacimiento) {
		this.fnacimiento = fnacimiento;
	}
	 
	 public String toString() {
		 return getNickname() + " (" + getNombre() + " " + getApellido() + ")";
	 }
}

