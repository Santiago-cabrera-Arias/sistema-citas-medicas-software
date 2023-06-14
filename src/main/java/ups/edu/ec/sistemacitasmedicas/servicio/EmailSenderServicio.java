package ups.edu.ec.sistemacitasmedicas.servicio;

import java.io.File;

public interface EmailSenderServicio {

    void sendEmail(String toUser, String subject, StringBuffer message);


}
