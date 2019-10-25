package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
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
    private String ruta;

    public ControladorPrincipal() {

        modeloArchivo = new ModeloArchivo();
        vista = new VistaVotos();
        productos = new ArrayList<>();
        //votos = this.modeloArchivo.votosProductos(productos);
        votos = new HashMap<String, Integer>();
        this.vista.btnBarra.addActionListener(this);
        this.vista.btnPastel.addActionListener(this);
        this.vista.btnVotar.addActionListener(this);
        this.vista.btnTotal.addActionListener(this);
        this.vista.btnAbrir.addActionListener(this);
        controladorBarra = new ControladorBarra(votos);
        controladorPastel = new ControladorPastel(votos);
        ruta = "";

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
        } else if (this.vista.btnAbrir == ae.getSource()) {
            ruta = this.modeloArchivo.obtenerRuta();
            productos = this.modeloArchivo.leerArchivoProductos(ruta);
            agregarProductos();
            votos = this.modeloArchivo.votosProductos(productos);
            this.controladorBarra.actualizarModelo(votos);
            this.controladorPastel.actualizarModelo(votos);
        }
    }

}
