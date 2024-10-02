package aed;

public class Fecha {
    private Integer dia;
    private Integer mes;

    public Fecha(Integer d, Integer m) {  
        dia = d;
        mes = m;
    }

    public Fecha(Fecha fecha) {   
        this.dia = fecha.dia;
        this.mes = fecha.mes;
    }
  
    public Integer dia() {
        return dia;
    }

    public Integer mes() {
        return mes;
    }

    @Override
    public String toString() {
        return dia + "/" + mes;
    }

    @Override
    public boolean equals(Object otra) {
        if (otra == null){
            return false;
        }
        if (otra.getClass() != this.getClass()){
            return false;
        }

        Fecha otrafecha = (Fecha) otra;
        return this.dia == otrafecha.dia && this.mes == otrafecha.mes;  
    }
    public void incrementarDia() {
        if (dia < diasEnMes(mes)) {
            dia = dia + 1;
        } 
        else {
            dia = 1;
            if (mes < 12) {
                mes = mes + 1;
            }
            else {
                mes = 1;
            }
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
