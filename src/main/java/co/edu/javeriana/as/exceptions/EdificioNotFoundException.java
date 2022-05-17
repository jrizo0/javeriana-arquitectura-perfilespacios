package co.edu.javeriana.as.exceptions;

import java.text.MessageFormat;

public class EdificioNotFoundException extends RuntimeException {

    public EdificioNotFoundException(final int id) {
        super(MessageFormat.format("Could not find Edificio with id: {0}", id));
    }
}
