
package modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author julio-cabrera
 */
public class Registro {
    
    private Date fechaCreacion;

    public Registro() {
        fechaCreacion = null;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
      public String obtenerFecha(){
        
        Date Fecha = new Date();
        DateFormat fecha = new SimpleDateFormat("HH:mm:ss dd/MM/YYYY");
        return fecha.toString();
    }
    

    @Override
    public String toString() {
        return "FechaCreacion " + fechaCreacion;
    }
   
}
