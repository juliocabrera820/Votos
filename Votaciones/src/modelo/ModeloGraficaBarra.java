package modelo;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author julio-cabrera
 */
public class ModeloGraficaBarra extends Observable {

    private Map<String, Integer> votos;

    public ModeloGraficaBarra() {
        votos = new HashMap<String, Integer>();
    }

    public Map<String, Integer> getVotos() {
        return votos;
    }

    public void setVotos(Map<String, Integer> votos) {
        this.votos = votos;
        
    }

    public DefaultCategoryDataset actualizarVotos(Map<String, Integer> productos) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> producto : productos.entrySet()) {
            data.addValue(producto.getValue(), "Votos", producto.getKey());
        }
        setChanged();
        notifyObservers();
        return data;
    }

}
