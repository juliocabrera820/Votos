
package modelo;

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

    @Override
    public String toString() {
        return "FechaCreacion " + fechaCreacion;
    }
   
}
