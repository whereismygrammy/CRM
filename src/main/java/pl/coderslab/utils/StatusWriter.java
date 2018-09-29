package pl.coderslab.utils;

import pl.coderslab.model.Status;

public class StatusWriter {

    public static String write(Status status) {
        if (status == Status.NEW) {
            return "Przyjęty";
        }
        if (status == Status.ACCEPTED) {
            return "Zatwierdzone koszty naprawy";
        }
        if (status == Status.IN_REPAIR) {
            return "W naprawie";
        }
        if (status == Status.READY) {
            return "Gotowy do odbioru";
        }
        if (status == Status.RESIGNATION) {
            return "Rezygnacja";
        }
        return null;
    }
}
