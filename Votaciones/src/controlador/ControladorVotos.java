package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
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
    private Map<String, Integer> votos;
     private Map<String, Integer> votos1;

    public ControladorVotos() {
        modelo = new ModeloVotos();
        vista = new VistaVotos();
        productos = this.modelo.leerArchivoProductos("C:\\Users\\alberto.rivero\\Desktop\\productos.txt");
        agregarProductos();
        votos = this.modelo.votosProductos(productos);
        votos1 = this.modelo.votosProductos(productos);
        this.vista.btnBarra.addActionListener(this);
        this.vista.btnPastel.addActionListener(this);
        this.vista.btnVotar.addActionListener(this);
    }
int num;
    @Override
    public void actionPerformed(ActionEvent ae) {
        num = this.vista.comboVotos.getSelectedIndex();
        if (this.vista.btnVotar == ae.getSource()) {
            String producto = String.valueOf(this.vista.comboVotos.getSelectedItem());
            
            if (producto.equals("Seleccionar")) {
                limpiarCampoVotos();
                JOptionPane.showMessageDialog(null, "Elija un producto");
            } else {
                this.modelo.votar(producto);
                mostrarVotos(producto);
                
            }
        } else if (this.vista.btnBarra == ae.getSource()) {
            this.votos = this.modelo.votosProductos(productos);
            this.modelo.generarBarras(votos);
        } else if (this.vista.btnPastel == ae.getSource()) {
            this.votos = this.modelo.votosProductos(productos);
            this.modelo.generarPastel(votos);
        }
    }
    
    public void mostrarVotos(String producto){
        votos =  this.modelo.votosProductos(productos);
        this.vista.txtVotos.setText(String.valueOf(votos.get(producto)));
        
        
    }

    public void agregarProductos() {
        for (String producto : productos) {
            this.vista.comboVotos.addItem(producto);
        }
    }
    
    
    public void limpiarCampoVotos(){
        this.vista.txtVotos.setText("");
    }

    public void iniciar() {
        this.vista.setTitle("Votaciones");
        this.vista.setSize(700, 440);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

    public void votacionesEquipos() {
        //votos.forEach((k, v) -> System.out.println("Producto " + k + " votos: " + v));
        /**
         * 
         * Ya no es necesario este metodo, ya tiene el contador integrado dentro de la app
         */
    }

}
