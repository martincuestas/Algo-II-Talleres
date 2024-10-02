package aed;

public class Recordatorio {           
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha(fecha);
        this.horario = horario;
    }
    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {              
        return new Fecha(this.fecha);
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        return (mensaje +" " + "@" + " " + fecha + " " + horario);
    }

    @Override
    public boolean equals(Object otro) {
        if (otro == null){
            return false;
        }
    
        if (otro.getClass() != this.getClass()){
            return false;
        }
        
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        return (this.fecha.equals(otroRecordatorio.fecha) && this.horario.equals(otroRecordatorio.horario) && otroRecordatorio.mensaje == this.mensaje);

    }

}
