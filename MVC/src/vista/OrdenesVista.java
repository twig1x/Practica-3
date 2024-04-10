package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrdenesVista extends JFrame {
    private JComboBox<String> cmbProductos;
    private JTextField txtCantidad;
    private JButton btnAgregar;
    private JTextArea txtAreaOrden;
    private JLabel lblFechaHora;
    private JLabel lblTotalProductos;
    private JButton btnGuardar;
    private JButton btnSalir;

    private LocalDateTime fechaHoraOrden;
    private StringBuilder ordenes;

    public OrdenesVista() {
        setTitle("Realizar Orden");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 450);
        setLocationRelativeTo(null);

        fechaHoraOrden = LocalDateTime.now();
        ordenes = new StringBuilder();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(30, 30, 80, 25);
        panel.add(lblProducto);

        cmbProductos = new JComboBox<>(new String[]{"Pan", "Dulces", "Pasteles"}); // Ejemplo de productos
        cmbProductos.setBounds(120, 30, 150, 25);
        panel.add(cmbProductos);

        JLabel lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setBounds(30, 70, 80, 25);
        panel.add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(120, 70, 150, 25);
        panel.add(txtCantidad);

        btnAgregar = new JButton("Agregar a la Orden");
        btnAgregar.setBounds(120, 110, 150, 25);
        panel.add(btnAgregar);

        lblFechaHora = new JLabel("Fecha y hora de la orden:");
        lblFechaHora.setBounds(30, 150, 300, 25);
        panel.add(lblFechaHora);

        lblTotalProductos = new JLabel("Total de productos en la orden:");
        lblTotalProductos.setBounds(30, 180, 300, 25);
        panel.add(lblTotalProductos);

        txtAreaOrden = new JTextArea();
        txtAreaOrden.setBounds(30, 220, 330, 100);
        panel.add(txtAreaOrden);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 350, 100, 25);
        panel.add(btnGuardar);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(200, 350, 100, 25);
        panel.add(btnSalir);

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProductoALaOrden();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarOrden();
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });

        add(panel);
        setVisible(true);
    }

    private void agregarProductoALaOrden() {
        String producto = (String) cmbProductos.getSelectedItem();
        int cantidad = Integer.parseInt(txtCantidad.getText()); // Suponiendo que se ingresa un número válido

        // Calcular el total de la orden (solo para fines de demostración)
        double precioUnitario = obtenerPrecioProducto(producto); // Supongamos que tenemos una función que devuelve el precio del producto
        double total = cantidad * precioUnitario;

        // Formatear la fecha y hora de la orden
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaHoraFormateada = fechaHoraOrden.format(formatter);

        // Agregar el producto a la orden y mostrarla en el área de texto
        String nuevaOrden = String.format("%s - Producto: %s, Cantidad: %d, Total: %.2f\n", fechaHoraFormateada, producto, cantidad, total);
        ordenes.append(nuevaOrden);
        txtAreaOrden.setText(ordenes.toString());

        // Actualizar la fecha y hora de la orden para la próxima orden
        fechaHoraOrden = LocalDateTime.now();

        // Actualizar la información de la orden mostrada
        lblFechaHora.setText("Fecha y hora de la orden: " + fechaHoraFormateada);
        lblTotalProductos.setText("Total de productos en la orden: " + ordenes.toString().split("\n").length);
    }

    private void guardarOrden() {
        // Mostrar la información de la orden en una ventana emergente
        JOptionPane.showMessageDialog(this, "Orden guardada:\n" + txtAreaOrden.getText());
    }

    private void salir() {
        // Salir de la aplicación
        System.exit(0);
    }

    // Método de ejemplo para obtener el precio del producto (simulado)
    private double obtenerPrecioProducto(String producto) {
        // Aquí podrías implementar la lógica para obtener el precio real del producto desde tu base de datos o algún otro origen de datos
        // En este ejemplo, simplemente retornamos un precio fijo para cada producto
        switch (producto) {
            case "Pan":
                return 2.50;
            case "Dulces":
                return 1.75;
            case "Pasteles":
                return 15.00;
            default:
                return 0.0; // Producto no reconocido
        }
    }
}
