package logica;
/**Representa a un usuario en el sistema. */
public class Usuario {

    private String nombre;
    private String apellido;
    private String nickname;
    private String email;
    private String fnacimiento;
    private boolean EsEntrenador = false;

    public Usuario(String n, String ap, String nickname, String email, String fnacimiento, boolean EsEntrenador) {
        this.nombre = n;
        this.apellido = ap;
        this.nickname = nickname;
        this.email = email;
        this.fnacimiento = fnacimiento;
        this.EsEntrenador = EsEntrenador;
    }
    
    
    
	public boolean isEsEntrenador() {
		return EsEntrenador;
	}

	public void setEsEntrenador(boolean esEntrenador) {
		EsEntrenador = esEntrenador;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(String fnacimiento) {
		this.fnacimiento = fnacimiento;
	}


}