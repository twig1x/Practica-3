/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

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
