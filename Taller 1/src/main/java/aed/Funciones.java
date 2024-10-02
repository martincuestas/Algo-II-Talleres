package aed;

class Funciones {
    int cuadrado(int x) {
        int res;
        res = x * x;
        return res;
    }

    double distancia(double x, double y) {
        double res;
        res = Math.sqrt(x*x + y*y);
        return res;
    }

    boolean esPar(int n) {
        boolean res;
        if (n % 2 == 0) {
            res = true;
        }
        else {
            res = false;
        }
        return res;
    }

    boolean esBisiesto(int n) {
        boolean res;
        res = false;
        if (n % 400 == 0) {
            res = true;
        } else if (n % 4 == 0) {
            if (n % 100 != 0) {
                res = true;
            }
        }
        return res;
    }

    int factorialIterativo(int n) {
        int x;
        x = 1;
        int paso;
        paso = 1;
        while (paso <= n) {
            x = paso * x;
            paso = paso + 1;
        }
        return x;
    }

    int factorialRecursivo(int n) {
        int res;
        if (n == 0) {
            res = 1;
        }
        else {
            res = (factorialRecursivo(n-1) * n);
        }
        return res;
    }

    boolean esPrimo(int n) {
        int totalDivisores;
        totalDivisores = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                totalDivisores = totalDivisores + 1;
            } }
        if (totalDivisores == 2) {
            return true;
        }
        else {
            return false; }
        
        }

    int sumatoria(int[] numeros) {
        int total; 
        total = 0;
        for (int x : numeros) {
            total = total + x;
        }
        return total;
    }

    int busqueda(int[] numeros, int buscado) {
        int res;
        res = 0;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == buscado) {
                res = i;
            }
        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        boolean res;
        res = false;
        for (int n : numeros) {
            if (esPrimo(n)) {
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        boolean res;
        res = true;
        for (int n : numeros) {
            if (n % 2 != 0) {
                res = false;
            }
        }
        return res;
    }

    boolean esPrefijo(String s1, String s2) {
        boolean res;
        res = true;
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if ( s1.charAt(i) != s2.charAt(i)) {
                res = false;
            }
        }
        return res;
    }

    boolean esSufijo(String s1, String s2) {
        String s1Invertido = "";
        String s2Invertido = "";
        if (s1.length() > s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++){
             s1Invertido += (s1.charAt(s1.length()- i - 1));
        }
        for (int i = 0; i < s1.length(); i++){
            s2Invertido += (s2.charAt(s2.length() - 1 - i));

        }
        return esPrefijo(s1Invertido, s2Invertido);
     
    }


}
