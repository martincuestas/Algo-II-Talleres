package aed;

public class Agenda {
    private Fecha fechaActual;
    private ArregloRedimensionableDeRecordatorios recordatorios;

    public Agenda(Fecha fechaActual) {
        this.fechaActual = fechaActual;
        
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        if (recordatorios == null){
        recordatorios = new ArregloRedimensionableDeRecordatorios();    
        this.recordatorios.agregarAtras(recordatorio);}
        else{
            this.recordatorios.agregarAtras(recordatorio);
        }
    }

    @Override
    public String toString() {
        String res =  this.fechaActual + "\n=====\n";
        for (int i = 0; i < this.recordatorios.longitud(); i++){
        if (recordatorios.obtener(i).fecha().equals(this.fechaActual)){
        res +=
        this.recordatorios.obtener(i).mensaje() + " " + "@" + " " + recordatorios.obtener(i).fecha() + " " + recordatorios.obtener(i).horario() + "\n";
    }}
    return res;
}

    public void incrementarDia() {
        fechaActual.incrementarDia();
    }

    public Fecha fechaActual() {
        return new Fecha(fechaActual);
    }

}
