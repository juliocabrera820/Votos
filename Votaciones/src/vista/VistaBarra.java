package vista;

import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author julio-cabrera
 */
public class VistaBarra implements Observer{

    private DefaultCategoryDataset datos;
    private JFreeChart grafica;
    private ChartFrame frame;

    public VistaBarra(DefaultCategoryDataset datos) {
        this.datos = datos;
        grafica = ChartFactory.createBarChart3D("Votaciones", "Productos", "Votos", datos, PlotOrientation.VERTICAL, true, true, true);
        frame = new ChartFrame("Votos", grafica);
    }

    public void iniciarVista() {
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {

        grafica = ChartFactory.createBarChart3D("Votaciones", "Productos", "Votos", (CategoryDataset) o1, PlotOrientation.VERTICAL, true, true, true);
        frame.getChartPanel().setChart(grafica);
    }
}
