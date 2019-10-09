package modelo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author julio-cabrera
 */
public class Modelo {

    private Grafica grafica;

    public Modelo() {
        grafica = new Grafica();
    }

    public ArrayList<String> leerArchivo(String ruta) {
        ArrayList<String> productos = new ArrayList<>();
        try {
            productos = (ArrayList<String>) Files.lines(Paths.get(ruta));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getStackTrace());
        }
        return productos;
    }

    public void escribirArchivo(String ruta) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta, true);
            pw = new PrintWriter(fichero);
            pw.println(obtenerFecha());
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getStackTrace());
        }
    }

    public String obtenerFecha() {
        Date fecha = new Date();
        DateFormat formato = new SimpleDateFormat("HH:mm:ss dd/MM/YYYY");
        return formato.format(fecha);
    }

    public void graficaBarra(int votos1, int votos2, int votos3) {
        grafica.generarBarras(votos1,votos2,votos3);
    }

    public void graficaPastel(int votos1, int votos2, int votos3) {
        grafica.generarPastel(votos1,votos2,votos3);
    }

}
