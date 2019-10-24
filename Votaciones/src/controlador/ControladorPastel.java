package controlador;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import modelo.ModeloGraficaPastel;
import org.jfree.data.general.DefaultPieDataset;
import vista.VistaPastel;

/**
 *
 * @author julio-cabrera
 */
public class ControladorPastel implements Observer {

    private ModeloGraficaPastel modelo;
    private VistaPastel vista;
    private ArrayList<String> productos;
    private Map<String, Integer> votos;

    public ControladorPastel(Map<String, Integer> votos) {

        modelo = new ModeloGraficaPastel();
        this.votos = votos;
        DefaultPieDataset datos = modelo.actualizarVotos(votos);
        vista = new VistaPastel(datos);
        vista.iniciarVista();
    }

    public void actualizarModelo(Map<String, Integer> votos) {
        DefaultPieDataset datos = this.modelo.actualizarVotos(votos);
        this.vista.update(modelo, datos);
    }

    @Override
    public void update(Observable o, Object o1) {
        DefaultPieDataset datos = this.modelo.actualizarVotos((Map<String, Integer>) o1);
    }

}
