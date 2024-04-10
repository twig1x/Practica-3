package main;

import controlador.LoginControlador;
import vista.LoginVista;

public class Main {
    public static void main(String[] args) {
        // Crear controlador
        LoginControlador controlador = new LoginControlador();

        // Crear vista y establecerla en el controlador
        LoginVista vista = new LoginVista(controlador);
        controlador.setVista(vista);
    }
}
