package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.ModeloArchivo;
import vista.VistaVotos;

/**
 *
 * @author julio-cabrera
 */
public class ControladorPrincipal implements ActionListener {

    private ControladorBarra controladorBarra;
    private ControladorPastel controladorPastel;
    private ModeloArchivo modeloArchivo;
    private VistaVotos vista;
    private ArrayList<String> productos;
    private Map<String, Integer> votos;

    public ControladorPrincipal() {

        modeloArchivo = new ModeloArchivo();
        vista = new VistaVotos();
        productos = this.modeloArchivo.leerArchivoProductos("/home/julio-cabrera/ArchivosProductos/Productos.txt");
        agregarProductos();
        votos = this.modeloArchivo.votosProductos(productos);
        this.vista.btnBarra.addActionListener(this);
        this.vista.btnPastel.addActionListener(this);
        this.vista.btnVotar.addActionListener(this);
        this.vista.btnTotal.addActionListener(this);
        controladorBarra = new ControladorBarra(votos);
        controladorPastel = new ControladorPastel(votos);

    }
     
    public void iniciar() {
        this.vista.setTitle("Votaciones");
        this.vista.setSize(700, 440);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    public void agregarProductos() {
        for (String producto : productos) {
            this.vista.comboVotos.addItem(producto);
        }
    }

    public void votacionesEquipos() {
        ArrayList nuevo = new ArrayList();
        nuevo.add(votos.toString());
        JOptionPane.showMessageDialog(null, nuevo);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (this.vista.btnVotar == ae.getSource()) {
            String producto = String.valueOf(this.vista.comboVotos.getSelectedItem());

            if (producto.equals("Seleccionar")) {

                JOptionPane.showMessageDialog(null, "Elija un producto");
            } else {
                this.modeloArchivo.votar(producto);
                this.votos = this.modeloArchivo.votosProductos(productos);
                this.controladorBarra.actualizarModelo(votos);
                this.controladorPastel.actualizarModelo(votos);
            }
        } else if (this.vista.btnTotal == ae.getSource()) {
            votacionesEquipos();
        }
    }

}
