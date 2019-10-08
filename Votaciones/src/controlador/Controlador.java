
package controlador;

import java.util.ArrayList;
import modelo.Modelo;
import modelo.Registro;

/**
 *
 * @author julio-cabrera
 */
public class Controlador {
    
    private ArrayList<Registro> votaciones;
    private Modelo modelo;

    public Controlador() {
        votaciones = new ArrayList<>();
        modelo = new Modelo();
    }
    
}
