
package modelo;

/**
 *
 * @author julio-cabrera
 */
public class Modelo {
    
    private Grafica grafica;

    public Modelo() {
        grafica = new Grafica();
    }
    
    public void graficaBarra(){
        grafica.generarBarras();
    }
    
    public void graficaPastel(){
        grafica.generarPastel();
    }
}
