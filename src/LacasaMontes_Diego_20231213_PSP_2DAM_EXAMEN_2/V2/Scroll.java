package LacasaMontes_Diego_20231213_PSP_2DAM_EXAMEN_2.V2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scroll {
    public static final int NUMERO_HILOS = 2;
    public static final int CADENCIA_ESCRITURA = 1;
    public static final int CADENCIA_HORA = 5;
    public static final int PAUSA_INICIAL = 0;

    public static void main(String[] args) {
        // Creación del objeto Buzon para almacenar información.
        Buzon a_Buzon = new Buzon();
        // Obtiene la hora actual del sistema y la asigna al objeto Buzon.
        Calendar l_Calendario = new GregorianCalendar();
        a_Buzon.a_Hora = l_Calendario.get(Calendar.HOUR_OF_DAY)
                + ":" + l_Calendario.get(Calendar.MINUTE)
                + ":" + l_Calendario.get(Calendar.SECOND);

        try {
            // Creación de los objetos Runnable y del ScheduledExecutorService para ejecutar tareas programadas.
            final Runnable l_ObjRunnable1 = new Letrero(a_Buzon);
            final Runnable l_ObjRunnable2 = new ControlTiempo(a_Buzon);
            final ScheduledExecutorService l_ExecutorPlan = Executors.newScheduledThreadPool(NUMERO_HILOS);

            // Programa la ejecución periódica de las tareas definidas.
            l_ExecutorPlan.scheduleWithFixedDelay(l_ObjRunnable1, PAUSA_INICIAL, CADENCIA_ESCRITURA, TimeUnit.SECONDS);
            l_ExecutorPlan.scheduleWithFixedDelay(l_ObjRunnable2, PAUSA_INICIAL, CADENCIA_HORA, TimeUnit.SECONDS);
        } catch(IllegalArgumentException ex){
            // Manejo de excepciones en caso de errores en el Scheduled Executor Service.
            System.out.println("Error en el Scheduled Executor Service");
        }
    }
}