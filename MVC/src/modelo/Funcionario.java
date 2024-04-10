package modelo;

public class Funcionario {
    private String usuario;
    private String contrasena;

    public Funcionario(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
