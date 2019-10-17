package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author julio-cabrera
 */
public class ModeloVotos {

    public ModeloVotos() {
    }

    public ArrayList<String> leerArchivoProductos(String ruta) {
        ArrayList<String> productos = new ArrayList<>();
        try {
            productos = Files.lines(Paths.get(ruta)).collect(Collectors.toCollection(ArrayList::new));
        } catch (IOException ex) {
            JOptionPane.showInputDialog(null, ex.getStackTrace());
        }
        return productos;
    }

    public void votar(String producto) {
        String ruta = "/home/julio-cabrera/ArchivosProductos/" + producto + ".txt";
        crearArchivo(ruta);
        escribirArchivo(ruta, obtenerFecha());
    }

    public void escribirArchivo(String ruta, String registro) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta, true);
            pw = new PrintWriter(fichero);
            pw.println(registro);
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

    public void crearArchivo(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showInputDialog(null, ex.getStackTrace());
            }
        }
    }

    public Map<String, Integer> votosProductos(ArrayList<String> productos) {
        Map<String, Integer> votos = new HashMap<String, Integer>();
        for (String producto : productos) {
            try {
                File archivo = new File("/home/julio-cabrera/ArchivosProductos/" + producto + ".txt");
                if (!archivo.exists()) {
                    votos.put(producto, 0);
                } else {
                    int votosProducto = (int) Files.lines(Paths.get("/home/julio-cabrera/ArchivosProductos/" + producto + ".txt")).count();
                    votos.put(producto, votosProducto);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getStackTrace());
            }
        }
        return votos;
    }

    public void generarBarras(Map<String, Integer> productos) {
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            for (Entry<String, Integer> producto : productos.entrySet()) {
                data.addValue(producto.getValue(), "Votos", producto.getKey());
            }
            JFreeChart jfre = ChartFactory.createBarChart3D("Votaciones", "Productos", "Votos", data, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame frame = new ChartFrame("Votos", jfre);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void generarPastel(Map<String, Integer> productos) {
        try {
            DefaultPieDataset data = new DefaultPieDataset();
            for (Entry<String, Integer> producto : productos.entrySet()) {
                data.setValue(producto.getKey(), producto.getValue());
            }
            JFreeChart jfree = ChartFactory.createPieChart3D("Votaciones", data, true, true, true);
            ChartFrame frame = new ChartFrame("Votaciones", jfree);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

}
