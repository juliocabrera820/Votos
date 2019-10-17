package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.ModeloVotos;
import vista.VistaVotos;

/**
 *
 * @author julio-cabrera
 */
public class ControladorVotos implements ActionListener {

    private ModeloVotos modelo;
    private VistaVotos vista;
    private ArrayList<String> productos;

    public ControladorVotos() {
        modelo = new ModeloVotos();
        vista = new VistaVotos();
        productos = this.modelo.leerArchivoProductos("/home/julio-cabrera/ArchivosProductos/Productos.txt");
        agregarProductos();
        this.vista.btnBarra.addActionListener(this);
        this.vista.btnPastel.addActionListener(this);
        this.vista.btnVotar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (this.vista.btnVotar == ae.getSource()) {
            String producto = String.valueOf(this.vista.comboVotos.getSelectedItem());
            if (producto.equals("Seleccionar")) {
                JOptionPane.showInputDialog(null, "Elija un producto");
            } else {
                this.modelo.votar(producto);
            }
        }
    }

    public void agregarProductos() {
        for (String producto : productos) {
            this.vista.comboVotos.addItem(producto);
        }
    }

    public void iniciar() {
        this.vista.setTitle("Votaciones");
        this.vista.setSize(700, 440);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

}
