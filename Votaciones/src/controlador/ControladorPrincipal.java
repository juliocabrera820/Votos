package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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
    private String carpeta;

    public ControladorPrincipal() {

        modeloArchivo = new ModeloArchivo();
        vista = new VistaVotos();
        productos = new ArrayList<>();
        votos = new HashMap<String, Integer>();
        this.vista.btnAbrir.addActionListener(this);
        controladorBarra = new ControladorBarra(votos);
        controladorPastel = new ControladorPastel(votos);
        ruta = "";
        carpeta = "";
        this.vista.btn1.addActionListener(this);
        this.vista.btn2.addActionListener(this);
        this.vista.btn3.addActionListener(this);
        this.vista.btnguardar.addActionListener(this);
    }

    public void iniciar() {
        this.vista.setTitle("Votaciones");
        this.vista.setSize(700, 440);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (this.vista.btnAbrir == ae.getSource()) {
            ruta = this.modeloArchivo.obtenerRuta();
            productos = this.modeloArchivo.leerArchivoProductos(ruta);
            votos = this.modeloArchivo.votosProductos(productos,carpeta,this.modeloArchivo.sistemaOperativo());
            this.controladorBarra.actualizarModelo(votos);
            this.controladorPastel.actualizarModelo(votos);
            nombrarBotones();
            this.vista.txt.setText(String.valueOf(this.votos.get((this.productos.get(0)))));
            this.vista.txt2.setText(String.valueOf(this.votos.get((this.productos.get(1)))));
            this.vista.txt3.setText(String.valueOf(this.votos.get((this.productos.get(2)))));
        } else if (this.vista.btn1 == ae.getSource()) {
            this.modeloArchivo.votar(this.productos.get(0),carpeta,this.modeloArchivo.sistemaOperativo());
            votos = this.modeloArchivo.votosProductos(productos,carpeta,this.modeloArchivo.sistemaOperativo());
            this.controladorBarra.actualizarModelo(votos);
            this.controladorPastel.actualizarModelo(votos);
            this.vista.txt.setText(String.valueOf(this.votos.get((this.productos.get(0)))));
        } else if (this.vista.btn2 == ae.getSource()) {
            this.modeloArchivo.votar(this.productos.get(1),carpeta,this.modeloArchivo.sistemaOperativo());
            votos = this.modeloArchivo.votosProductos(productos,carpeta,this.modeloArchivo.sistemaOperativo());
            this.controladorBarra.actualizarModelo(votos);
            this.controladorPastel.actualizarModelo(votos);
            this.vista.txt2.setText(String.valueOf(this.votos.get(this.productos.get(1))));
        } else if (this.vista.btn3 == ae.getSource()) {
            this.modeloArchivo.votar(this.productos.get(2),carpeta,this.modeloArchivo.sistemaOperativo());
            votos = this.modeloArchivo.votosProductos(productos,carpeta,this.modeloArchivo.sistemaOperativo());
            this.controladorBarra.actualizarModelo(votos);
            this.controladorPastel.actualizarModelo(votos);
            this.vista.txt3.setText(String.valueOf(this.votos.get(this.productos.get(2))));
        }else if(this.vista.btnguardar == ae.getSource()){
            carpeta = this.modeloArchivo.obtenerCarpeta();
        }
    }

    public void nombrarBotones() {
        this.vista.btn1.setText(productos.get(0));
        this.vista.btn2.setText(productos.get(1));
        this.vista.btn3.setText(productos.get(2));
    }

}
