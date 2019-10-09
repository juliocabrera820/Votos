package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import modelo.Modelo;
import vista.Vista;

/**
 *
 * @author julio-cabrera
 */
public class Controlador implements ActionListener {

    private Modelo modelo;
    private Vista vista;
    private int votos1, votos2, votos3;

    public Controlador() {
        modelo = new Modelo();
        vista = new Vista();
        vista.btn1.addActionListener(this);
        vista.btn2.addActionListener(this);
        vista.btn3.addActionListener(this);
        vista.btnBarra.addActionListener(this);
        vista.btnPastel.addActionListener(this);
        votos1 = votos2 = votos3 = 0;
        this.vista.txtVoto1.setText(String.valueOf(votos1));
        this.vista.txtVoto2.setText(String.valueOf(votos2));
        this.vista.txtVoto3.setText(String.valueOf(votos3));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        ArrayList<String> votaciones = new ArrayList<>();
        if (this.vista.btn1 == ae.getSource()) {
            modelo.escribirArchivo("/home/julio-cabrera/ArchivosProductos/prod1.txt");
            votos1++;
            this.vista.txtVoto1.setText(String.valueOf(votos1));
        }
        if (this.vista.btn2 == ae.getSource()) {
            modelo.escribirArchivo("/home/julio-cabrera/ArchivosProductos/prod2.txt");
            votos2++;
            this.vista.txtVoto2.setText(String.valueOf(votos2));
        }
        if (this.vista.btn3 == ae.getSource()) {
            modelo.escribirArchivo("/home/julio-cabrera/ArchivosProductos/prod3.txt");
            votos3++;
            this.vista.txtVoto3.setText(String.valueOf(votos3));
        }
        if (this.vista.btnBarra == ae.getSource()) {
            votaciones = this.modelo.leerArchivo("/home/julio-cabrera/ArchivosProductos/prod1.txt");
            this.modelo.graficaBarra(votaciones);
        }
        if (this.vista.btnPastel == ae.getSource()) {
            votaciones = this.modelo.leerArchivo("/home/julio-cabrera/ArchivosProductos/prod1.txt");
            this.modelo.graficaPastel(votaciones);
        }

    }

    public void iniciar() {
        this.vista.setTitle("Votaciones");
        this.vista.setSize(800, 600);
        this.vista.setLocationRelativeTo(null);
        this.vista.setVisible(true);
    }

}
