/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import vista.LoginVista;
import vista.OrdenesVista;

public class LoginControlador {
    private LoginVista vista;

    public void setVista(LoginVista vista) {
        this.vista = vista;
    }

    public void iniciarSesion(String usuario, String contrasena) {
        // Lógica de autenticación
        if ("admin".equals(usuario) && "admin".equals(contrasena)) {
            vista.mostrarMensaje("Inicio de sesión exitoso");
            // Abrir la vista de órdenes
            OrdenesVista ordenesVista = new OrdenesVista();
            ordenesVista.setVisible(true);
        } else {
            vista.mostrarMensaje("Usuario o contraseña incorrectos");
        }
    }
}
