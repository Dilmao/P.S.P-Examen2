package LacasaMontes_Diego_20231213_PSP_2DAM_EXAMEN_2.V1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**********************************************************************************************************************************************
 *   APLICACIÓN: "2º Examen 2º DAM"                                                                                                           *
 **********************************************************************************************************************************************
 *   PROGRAMACIÓN DE SERVICIOS Y PROCESOS 2DAM  -  IntelliJ IDE for Java Developers                                                           *
 **********************************************************************************************************************************************
 *   @author D.Lacasa                                                                                                                         *
 *   @version 1.0 - Versión inicial del programa.                                                                                             *
 *   @since 13DIC2023                                                                                                                         *
 **********************************************************************************************************************************************
 *   COMENTARIOS:                                                                                                                             *
 *      - El codigo imprimira por pantalla dos líneas de texto cada segundo:                                                                  *
 *          - La primera línea imprimirá la hora actual del sistema hasta los segundos. Su contenido se refrescará cada 5 segundos.           *
 *          - La segunda línea imprimirá una serie de mensajes de texto en un scroll de 8 caracteres de longitud.                             *
 **********************************************************************************************************************************************/
/*
* TODO´s:
*   - Hacer que la hora se refresque solo cada 5 segundos
*   - Mostrar el String en bucle*/
public class Scroller {
    public static final int NUMERO_HILOS = 1;
    public static final int CADENCIA_ESCRITURA = 1;
    public static final int CADENCIA_HORA = 5;
    public static final int PAUSA_INICIAL = 0;
    public static final int LONGITUD_SCROLL = 8;

    static class Scroll implements Runnable {
        private final String a_Frase;
        private int a_Contador = 0;
        public Scroll(String p_Frase) {
            a_Frase = p_Frase;
        }

        @Override
        public void run() {
            // Se generan las variables de hora y texto que se mostraran posteriormente
            DateTimeFormatter l_FormatoTiempo = DateTimeFormatter.ofPattern("hh:mm:ss");
            String l_Hora = l_FormatoTiempo.format(LocalDateTime.now());
            String l_Frase = String.copyValueOf(a_Frase.toCharArray(), a_Contador, LONGITUD_SCROLL);

            // Se imprimen la hora y el Scroll de texto
            System.out.println(l_Hora);
            System.out.println(l_Frase);
            if (a_Contador == a_Frase.length() - 8) {
                a_Contador = -1;
            }

            // Se aumenta el contador para que la proxima ejecución el texto mostrado este un caracter más a la derecha
            a_Contador++;
        }
    }
    public static void main(String[] args) {
        // Declaracion de variables
        final ScheduledExecutorService l_EjecutorPlan = Executors.newScheduledThreadPool(NUMERO_HILOS);
        String l_Frase = "        Java fue creado por James Gosling. Java fue publicado por Sun Microsystems. Java se liberó el 23 de Enero de 1996.       ";
        final Runnable l_ObjRunnable = new Scroll(l_Frase);

        // Se programa la ejecución del Scroll para que se ejecute cada segundo
        l_EjecutorPlan.scheduleWithFixedDelay(l_ObjRunnable, PAUSA_INICIAL, CADENCIA_ESCRITURA, TimeUnit.SECONDS);
    }
}