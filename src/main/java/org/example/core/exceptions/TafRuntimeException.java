package org.example.core.exceptions;

public class TafRuntimeException extends RuntimeException {

    public TafRuntimeException() {
        super();
    }

    public TafRuntimeException(String message) {
        super(message);
    }

    public TafRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public TafRuntimeException(Throwable cause) {
        super(cause);
    }

}
