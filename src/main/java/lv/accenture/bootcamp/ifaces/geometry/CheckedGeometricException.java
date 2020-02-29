package lv.accenture.bootcamp.ifaces.geometry;

public class CheckedGeometricException extends Exception {

    public CheckedGeometricException(String message) {
        super(message);
    }

    public CheckedGeometricException(String message, Throwable cause) {
        super(message, cause);
    }
}
