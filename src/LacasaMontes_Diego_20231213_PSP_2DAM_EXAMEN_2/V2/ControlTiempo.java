package LacasaMontes_Diego_20231213_PSP_2DAM_EXAMEN_2.V2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class ControlTiempo implements Runnable {
    public Buzon a_Buzon = null;

    public ControlTiempo(Buzon a_Buzon) {
        this.a_Buzon = a_Buzon;
    }

    @Override
    public void run() {
        // Actualiza la hora en el objeto Buzon.
        Calendar l_Calendario = new GregorianCalendar();
        a_Buzon.a_Hora = l_Calendario.get(Calendar.HOUR_OF_DAY)
                + ":" + l_Calendario.get(Calendar.MINUTE)
                + ":" + l_Calendario.get(Calendar.SECOND);
    }
}