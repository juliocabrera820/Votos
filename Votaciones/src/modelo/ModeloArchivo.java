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
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author julio-cabrera
 */
public class ModeloArchivo {

    public ModeloArchivo() {
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

    public void votar(String producto, String carpeta, String OS) {
        String slash = "";
        if (!OS.equals("Linux")) {
            slash = "\\";
        } else {
            slash = "/";
        }
        String ruta = carpeta + slash + producto + ".txt";
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

    public Map<String, Integer> votosProductos(ArrayList<String> productos, String carpeta, String OS) {
        Map<String, Integer> votos = new HashMap<String, Integer>();
        for (String producto : productos) {
            try {
                String slash = "";
                if (!OS.equals("Linux")) {
                    slash = "\\";
                } else {
                    slash = "/";
                }
                File archivo = new File(carpeta + slash + producto + ".txt");
                if (!archivo.exists()) {
                    votos.put(producto, 0);
                } else {
                    int votosProducto = (int) Files.lines(Paths.get(carpeta + slash + producto + ".txt")).count();
                    votos.put(producto, votosProducto);
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getStackTrace());
            }
        }
        return votos;
    }

    public String obtenerRuta() {
        JFileChooser seleccion = new JFileChooser();
        String ruta = "";
        int opcion = seleccion.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            ruta = seleccion.getSelectedFile().getAbsolutePath();
        }
        return ruta;
    }

    public String obtenerCarpeta() {
        JFileChooser seleccion = new JFileChooser();
        seleccion.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        String ruta = "";
        int opcion = seleccion.showOpenDialog(null);
        if (opcion == JFileChooser.APPROVE_OPTION) {
            ruta = seleccion.getSelectedFile().getAbsolutePath();
        }
        return ruta;
    }

    public String sistemaOperativo() {
        String sistemaOperativo = System.getProperty("os.name");
        return sistemaOperativo;
    }

    public void escribirBitacora(String carpeta, String OS, String registro) {
        String slash = "";
        if (!OS.equals("Linux")) {
            slash = "\\";
        } else {
            slash = "/";
        }
        String ruta = carpeta + slash + "bitacora.txt";
        crearArchivo(ruta);
        escribirArchivo(ruta, registro +" "+ obtenerFecha());
    }

}
