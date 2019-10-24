package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import modelo.ModeloGraficaBarra;
import org.jfree.data.category.DefaultCategoryDataset;
import vista.VistaBarra;

/**
 *
 * @author julio-cabrera
 */
public class ControladorBarra implements Observer {

    private ModeloGraficaBarra modelo;
    private VistaBarra vista;
    private ArrayList<String> productos;
    private Map<String, Integer> votos;

    public ControladorBarra(Map<String, Integer> votos) {

        modelo = new ModeloGraficaBarra();
        this.votos = votos;
        DefaultCategoryDataset datos = modelo.actualizarVotos(votos);
        vista = new VistaBarra(datos);
        vista.iniciarVista();

    }

    public void actualizarModelo(Map<String, Integer> votos) {
        DefaultCategoryDataset datos = this.modelo.actualizarVotos(votos);
        this.vista.update(modelo, datos);
    }

    @Override
    public void update(Observable o, Object o1) {
        this.modelo.actualizarVotos((Map<String, Integer>) o1);
    }

}
