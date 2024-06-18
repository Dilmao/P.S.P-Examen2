package LacasaMontes_Diego_20231213_PSP_2DAM_EXAMEN_2.V2;

public class Letrero implements Runnable {
    private final Buzon a_Buzon;

    public Letrero(Buzon p_Buzon) {
        this.a_Buzon = p_Buzon;
    }

    @Override
    public void run() {
        // Variables.
        int l_Desde = a_Buzon.a_Contador;
        int l_Hasta = a_Buzon.a_Contador + a_Buzon.a_LongitudScroll;

        // Obtiene una porción de la frase completa según la posición del contador.
        String l_Mensaje = a_Buzon.FRASE_COMPLETA.substring(l_Desde, l_Hasta);

        // Imprime la hora actual y el mensaje desplazado.
        System.out.println(a_Buzon.a_Hora);
        System.out.println(l_Mensaje);

        // Se comprueba si se ha llegado al final de la frase.
        if (l_Hasta == a_Buzon.FRASE_COMPLETA.length()) {
            // Si el contador alcanza el final de la frase, se reinicia.
            a_Buzon.a_Contador = 0;
        } else {
            // En caso contrario, se aumenta el contador para mostrar la siguiente letra.
            a_Buzon.a_Contador++;
        }
    }
}