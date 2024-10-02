package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        recordatorios = new Recordatorio[]{};
    }

    public int longitud() {
        return this.recordatorios.length;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] aux = new Recordatorio[recordatorios.length + 1];
        for (int n = 0; n < recordatorios.length; n++ ){
            aux [n] = recordatorios [n];
        }
        aux[aux.length - 1] = i;
        recordatorios = aux;
    }

    public Recordatorio obtener(int i) {
        return recordatorios[i];
    }

    public void quitarAtras() {
        Recordatorio[] aux = new Recordatorio[recordatorios.length - 1];
        for (int i = 0; i < aux.length; i++){
            aux [i] = recordatorios[i];
        }
        recordatorios = aux;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        recordatorios[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        Recordatorio[] recordatoriosaux = new Recordatorio[vector.recordatorios.length];
        for (int i = 0; i < vector.recordatorios.length; i ++){
            recordatoriosaux[i] = vector.recordatorios[i];
        }

        this.recordatorios = recordatoriosaux;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios copia = new ArregloRedimensionableDeRecordatorios();
        for (int i = 0; i < recordatorios.length; i++){
            copia.agregarAtras(recordatorios[i]);          
        }
        return copia;

    }
}
