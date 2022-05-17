package co.edu.javeriana.as.exceptions;

import java.text.MessageFormat;

public class EspacioNotFoundException extends RuntimeException {

    public EspacioNotFoundException(final int id) {
        super(MessageFormat.format("Could not find Espacio with id: {0}", id));
    }
}
