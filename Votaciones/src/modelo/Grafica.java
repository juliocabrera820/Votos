package modelo;

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

    public void generarBarras() {
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            data.addValue(20, "Persona", "Candidato 1");
            data.addValue(25, "Persona", "Candidato 2");
            data.addValue(40, "Persona", "Candidato 3");

            JFreeChart jfre = ChartFactory.createBarChart3D("Votaciones", "Candidatos", "Votos", data, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame frame = new ChartFrame("Votos", jfre);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
    }

    public void generarPastel() {
        try {
            DefaultPieDataset data = new DefaultPieDataset();
            data.setValue("candidato1", 35);
            data.setValue("candidato2", 15);
            data.setValue("candidato3", 50);
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
