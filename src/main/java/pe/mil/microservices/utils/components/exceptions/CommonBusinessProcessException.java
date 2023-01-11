package pe.mil.microservices.utils.components.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import pe.mil.microservices.utils.components.enums.ResponseCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CommonBusinessProcessException extends RuntimeException {

    private static final long serialVersionUID = 6626574252078520799L;

    private ResponseCode responseCode;

    public CommonBusinessProcessException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }

    public CommonBusinessProcessException(String message, ResponseCode responseCode) {
        super(message);
        this.responseCode = responseCode;
    }

    public CommonBusinessProcessException(String message, Throwable cause, ResponseCode responseCode) {
        super(message, cause);
        this.responseCode = responseCode;
    }

    public CommonBusinessProcessException(Throwable cause, ResponseCode responseCode) {
        super(cause);
        this.responseCode = responseCode;
    }

    public CommonBusinessProcessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResponseCode responseCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.responseCode = responseCode;
    }
}
