package LacasaMontes_Diego_20231213_PSP_2DAM_EXAMEN_2.V2;

public class Letrero implements Runnable {
    private Buzon a_Buzon = null;

    public Letrero(Buzon p_Buzon) {
        this.a_Buzon = p_Buzon;
    }

    @Override
    public void run() {
        // Obtiene una porción de la frase completa según la posición del contador.
        String l_Mensaje = String.copyValueOf(a_Buzon.a_FraseCompleta.toCharArray(), a_Buzon.a_Contador, a_Buzon.a_LongitudScroll);

        // Imprime la hora actual y el mensaje desplazado.
        System.out.println(a_Buzon.a_Hora);
        System.out.println(l_Mensaje);

        // Si el contador alcanza el final de la frase, se reinicia.
        if (a_Buzon.a_Contador == a_Buzon.a_FraseCompleta.length() - 8) {
            a_Buzon.a_Contador = -1;
        }

        // Incrementa el contador para desplazar la siguiente porción de la frase.
        a_Buzon.a_Contador++;
    }
}