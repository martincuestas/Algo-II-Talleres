package aed;
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo raiz;
    private int contador;

    private class Nodo {
        private T valor;
        private Nodo izquierda;
        private Nodo derecha;
        private Nodo padre;
        private Nodo(T v){valor = v;}
    }

    public ABB() {
        this.raiz = null;
        this.contador = 0;
    }

    public int cardinal() {
        return contador;
    }

    public T minimo(){
        Nodo res = raiz;
        while (res.izquierda != null){
            res = res.izquierda;
        }
        return res.valor;
    }

    public T maximo(){
        Nodo res = raiz;
        while (res.derecha != null){
            res = res.derecha;
        }
        return res.valor;
    }

    public void insertar(T elem){ 
        if (raiz == null){
            raiz = new Nodo(elem);
            raiz.izquierda = null;
            raiz.derecha = null;
            raiz.padre = null;
            contador = contador + 1;

        }
        else{
            Nodo actual = raiz;
            Nodo anterior = null;
            while (actual != null){
            anterior = actual;
            int comparacion = elem.compareTo(actual.valor);
            if (comparacion > 0){
                actual = actual.derecha;
            }
            if (comparacion < 0){
                actual = actual.izquierda;
            }
            if (comparacion == 0){          
                return;
            }
        
        }
            Nodo nuevo = new Nodo(elem);
            nuevo.padre = anterior;
            nuevo.izquierda = null;
            nuevo.derecha = null;
            contador = contador + 1;
            if(elem.compareTo(anterior.valor) < 0){
            anterior.izquierda = nuevo;
            }
            else{
                anterior.derecha = nuevo;
            }
        }


    }
    
    public boolean pertenece(T elem){
        Nodo actual = raiz;
        while (actual !=null){
            int comparacion = elem.compareTo(actual.valor);
            if (comparacion < 0){
                actual = actual.izquierda;
            }
            else if (comparacion > 0){
                actual = actual.derecha;
            }
            else if (comparacion == 0){
                return true;
            }
        }
        return false;
}

    public void eliminar(T elem){
        Nodo reemplazar = nodoConTElemento(elem);
        Nodo reemplazo = buscarMasAlaIzqDeDerecha(reemplazar);
        if (reemplazar.izquierda != null && reemplazar.derecha != null){
            reemplazar.valor = reemplazo.valor;
            if (reemplazo == reemplazo.padre.izquierda){
                reemplazo.padre.izquierda = reemplazo.derecha;}
                    
            else{
                reemplazo.padre.derecha = reemplazo.derecha;
            }
            if (reemplazo.derecha != null){
                reemplazo.derecha.padre = reemplazo.padre;
            }
        }
        else if (reemplazar.izquierda == null && reemplazar.derecha == null){
           if (reemplazar != raiz){
           
            if (reemplazar == reemplazar.padre.izquierda){
                reemplazar.padre.izquierda = null;
            }
            else{
                reemplazar.padre.derecha = null;
            }
        }
        else{
            raiz = null;
        }
    }
        else if (reemplazar.izquierda == null && reemplazar.derecha != null){
            if  (reemplazar != raiz){
            Nodo atras = reemplazar.padre;
            if (atras.derecha == reemplazar){
            atras.derecha = reemplazar.derecha;
            }
            else{
            atras.izquierda = reemplazar.derecha;
            }
            reemplazar.derecha.padre = atras;
        
        }
            else{
                reemplazar.derecha.padre = null;
                raiz = reemplazar.derecha;
            }  
        }
        else if (reemplazar.izquierda != null && reemplazar.derecha == null){
            if (reemplazar != raiz){
            Nodo atras = reemplazar.padre;
            if(atras.izquierda == reemplazar){
            atras.izquierda = reemplazar.izquierda;
            }
            else{
                atras.derecha = reemplazar.izquierda;
            }
            reemplazar.izquierda.padre = atras;
        }
            else{
                reemplazar.izquierda.padre = null;
                raiz = reemplazar.izquierda;
            }
        }
        contador = contador - 1;
        }

 
    private Nodo nodoConTElemento (T elem){    // SUPONGO QUE EL ELEMENTO PERTENECE
        Nodo actual = raiz;
        while (! actual.valor.equals(elem)){
            int comparacion = elem.compareTo(actual.valor);
            if (comparacion < 0){
                actual = actual.izquierda;
            }
            else if (comparacion > 0){
                actual = actual.derecha;
            }
        }
        return actual;

    }

    private Nodo buscarMasAlaIzqDeDerecha(Nodo origen){
        Nodo actual = origen.derecha;
        Nodo anterior = null;
        while (actual != null){
            anterior = actual;
            actual = actual.izquierda;
        }
        return anterior;

    }

    public String toString(){
        String res = "{";
        if (contador != 0){
        Nodo actual = nodoConTElemento(this.minimo());
        Nodo end = nodoConTElemento(this.maximo());
        while (actual != end){
            res += actual.valor + ",";
            
            actual = sucesor(actual);
        }
        res += end.valor + "}";
        
        }

        else{
            res = "{}";
        }
        return res;
    }
    private Nodo sucesor (Nodo nodo){
        Nodo res;
        if (nodo.derecha != null){
            res = nodo.derecha;
            while (res.izquierda != null){
                res = res.izquierda;
            }
        }
        else{
            res = nodo.padre;
            // hijo = nodo;
            while (res.derecha.valor == nodo.valor){
                // hijo = res;
                res = res.padre;
            }

        }
        return res;

    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo actual;
        
        public ABB_Iterador(){
            actual = nodoConTElemento(minimo());
        }

        public boolean haySiguiente() {
            return sucesor(actual) != null;
        }
    
        public T siguiente() {
            T res = actual.valor;
            actual = sucesor(actual);
            return res;
            
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
