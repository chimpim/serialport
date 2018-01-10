package com.chimpim.serialport;

public class SerialPortException extends Exception {

    private static final long serialVersionUID = -7034248811013913653L;

    public SerialPortException(String message) {
        super(message);
    }

    public SerialPortException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialPortException() {
        super();
    }

    public SerialPortException(Throwable cause) {
        super(cause);
    }

}
