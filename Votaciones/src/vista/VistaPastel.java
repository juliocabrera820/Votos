package vista;

import java.util.Observable;
import java.util.Observer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author julio-cabrera
 */
public class VistaPastel implements Observer{

    private DefaultPieDataset datos;
    private JFreeChart grafica;
    private ChartFrame frame;

    public VistaPastel(DefaultPieDataset datos) {
        this.datos = datos;
        grafica = ChartFactory.createPieChart3D("Votaciones", datos, true, true, true);
        frame = new ChartFrame("Votaciones", grafica);
    }
    
    public void iniciarVista(){
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void update(Observable o, Object o1) {

        grafica = ChartFactory.createPieChart3D("Votaciones",(DefaultPieDataset)o1 , true, true, true);
        frame.getChartPanel().setChart(grafica);
    }

}
