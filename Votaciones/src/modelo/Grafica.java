package modelo;

import java.util.ArrayList;
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
public class Grafica {

    public Grafica() {
    }

    public void generarBarras(ArrayList<String> registros) {
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            data.addValue(registros.size(), "Votos", "Producto 1");
            JFreeChart jfre = ChartFactory.createBarChart3D("Votaciones", "Candidatos", "Votos", data, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame frame = new ChartFrame("Votos", jfre);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void generarPastel(ArrayList<String> registros) {
        try {
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("Producto 1", registros.size());
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
