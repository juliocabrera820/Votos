package modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author julio-cabrera
 */
public class Modelo {

    private Grafica grafica;

    public int sumarArchivo(String direccion) {
        //Principal pr = new Principal();
        int sumador = 0;
        File ruta = new File(direccion);
        try {
            FileReader fr = new FileReader(direccion);
            BufferedReader br = new BufferedReader(fr);
            String cadena = null;

            while ((cadena = br.readLine()) != null) {
                StringTokenizer dato = new StringTokenizer(cadena, " ");
                sumador++;
            }
            return sumador;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getStackTrace());
        }

        return sumador;
    }

    public Modelo() {
        grafica = new Grafica();
    }

    public void graficaBarra() {
        grafica.generarBarras();
    }

    public void graficaPastel() {
        grafica.generarPastel();
    }
    
    //TODO OBTENER FECHA DEL VOTO
}
