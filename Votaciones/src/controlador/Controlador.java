
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Modelo;
import modelo.Registro;
import vista.Vista;

/**
 *
 * @author julio-cabrera
 */
public class Controlador implements ActionListener{
    
    private ArrayList<Registro> votaciones;
    private Modelo modelo;
    private Vista vista;

    public Controlador() {
        votaciones = new ArrayList<>();
        modelo = new Modelo();
        vista = new Vista();
        vista.btn1.addActionListener(this);
        vista.btn2.addActionListener(this);
        vista.btn3.addActionListener(this);
        vista.btnPastel.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if( this.vista.btn1 == ae.getSource()){
            //TODO VOTO1
        }
        if(this.vista.btn2 == ae.getSource()){
            //TODO VOTO2
        }
        if(this.vista.btn3 == ae.getSource()){
            //TODO VOTO3
        }
        if(this.vista.btnBarra == ae.getSource()){
            
        }
        if(this.vista.btnPastel == ae.getSource()){
            
        }
        //TODO BOTON GRAFICA BARRA
        //TODO BOTON GRAFICA PASTEL
    }
    
}
