package aed;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;

    private class Nodo {
        T Valor;
        Nodo anterior;
        Nodo siguiente;
        Nodo (T v) { Valor = v;}
    }

    public ListaEnlazada() {
        this.primero = null;
    }

    public int longitud() {
        Nodo actual = this.primero;
        int contador = 0;
        while (actual != null){
            contador = contador + 1;
            actual = actual.siguiente;
        }
        return contador;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        nuevo.siguiente = this.primero;
        nuevo.anterior = null;
        primero = nuevo;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
        }
        else{
            Nodo actual = this.primero;
            while(actual.siguiente != null){
            actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }

    public T obtener(int i) {
        Integer indice = 0;
        Nodo actual = this.primero;
        while (indice != i){
            indice = indice + 1;
            actual = actual.siguiente;
        }
        return actual.Valor;

    }
    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo previo = primero;
        for (Integer j = 0; j < i; j++){
            previo = actual;
            actual = actual.siguiente;
        }
        if (i == 0){
        primero = actual.siguiente;
        if (primero != null){
        primero.anterior = null;
    } }
    else{
        previo.siguiente = actual.siguiente;
        if (actual.siguiente != null){
        actual.siguiente.anterior = previo;
    }} 
   }


    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j = 0; j < indice; j ++){
            actual = actual.siguiente;
        }
    actual.Valor = elem;
    }


    public ListaEnlazada(ListaEnlazada<T> lista) {
            Nodo actual = lista.primero;
            this.primero = new Nodo(lista.primero.Valor);
            Nodo aux = this.primero;
            while (actual != null){
                aux.Valor = actual.Valor;
                aux.siguiente = actual.siguiente;
                aux.anterior = actual.anterior;
                aux = aux.siguiente;
                actual = actual.siguiente;
            }
    }
    
    @Override
    public String toString() {
        String res = "[";
        Nodo actual = this.primero;
        while (actual.siguiente != null){
        res += actual.Valor + "," + " ";
        actual = actual.siguiente;
    }
    res = res + actual.Valor + "]";
    return res;
     }


    private class ListaIterador implements Iterador<T> {
    	private int dedito;

        public ListaIterador() {
            dedito = 0;
        }

        public boolean haySiguiente() {
            Nodo actual = primero;
             for (Integer j = 0; j < dedito; j ++){
                actual = actual.siguiente;
             }
             return actual != null;
        }

        public boolean hayAnterior() {
	        Nodo actual = primero; 
            for (Integer j = 0; j < dedito - 1; j ++){
                actual = actual.siguiente;
             }
             if (dedito == 0){
                return false;
             }
             else{
                return actual != null;
             }
           }

        public T siguiente() {
            Nodo actual = primero;
             for (Integer j = 0; j < dedito; j ++){
                actual = actual.siguiente;
             }
             dedito = dedito + 1;
             T res = actual.Valor;
             actual = actual.siguiente;
             return res;
        }
        
        public T anterior() {
            Nodo actual = primero;
             for (Integer j = 0; j < dedito - 1; j ++){
                actual = actual.siguiente;
             }
             dedito = dedito - 1;
             return actual.Valor;
        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }

}
