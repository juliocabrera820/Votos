package principal;

import modelo.Grafica;
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
public class Principal {

    public static void main(String[] args) {

        Grafica grafica = new Grafica();
        grafica.generarBarras();
        grafica.generarPastel();
    }

}
