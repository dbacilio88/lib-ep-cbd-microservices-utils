package pe.mil.microservices.utils.components.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.mil.microservices.utils.components.enums.ResponseCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SoapProcessException extends RuntimeException {
    private static final long serialVersionUID = -8690588786589886124L;

    private ResponseCode responseCode;

    public SoapProcessException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public SoapProcessException(String message) {
        super(message);
    }

    public SoapProcessException(String message, ResponseCode responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public SoapProcessException(String message, ResponseCode responseCode, Throwable cause) {
        super(message, cause);
        this.responseCode = responseCode;
    }
}
