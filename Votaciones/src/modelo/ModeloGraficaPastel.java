package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author julio-cabrera
 */
public class ModeloGraficaPastel extends Observable {

    private Map<String, Integer> votos;

    public ModeloGraficaPastel() {

        votos = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getVotos() {
        return votos;
    }

    public void setVotos(Map<String, Integer> votos) {
        this.votos = votos;
    }

    public DefaultPieDataset actualizarVotos(Map<String, Integer> productos) {
        DefaultPieDataset data = new DefaultPieDataset();
        for (Map.Entry<String, Integer> producto : productos.entrySet()) {
            data.setValue(producto.getKey(), producto.getValue());
        }
        
        setChanged();
        notifyObservers();
        return data;
    }

}
