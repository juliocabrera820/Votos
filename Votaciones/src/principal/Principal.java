package principal;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author julio-cabrera
 */
public class Principal {

    public static void main(String[] args) {
        /**
         * Ejemplo con valores por defecto
         */
        //Grafica de barras
        generarBarras();

    }

    public static void generarBarras() {
        try {
            DefaultCategoryDataset data = new DefaultCategoryDataset();
            data.addValue(20, "Persona", "Candidato 1");
            data.addValue(25, "Persona", "Candidato 2");
            data.addValue(40, "Persona", "Candidato 3");

            JFreeChart jfre = ChartFactory.createBarChart3D("Votaciones", "Candidatos", "Votos", data, PlotOrientation.VERTICAL, true, true, true);
            ChartFrame frame = new ChartFrame("Votos",jfre);
            frame.setSize(600, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
    }

}
