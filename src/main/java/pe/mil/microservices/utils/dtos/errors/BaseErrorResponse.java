package pe.mil.microservices.utils.dtos.errors;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseErrorResponse implements Serializable {

    private static final long serialVersionUID = 6053261505886471051L;

    String info;

    List<ErrorResponse> errors;

    @Data
    @Builder
    @ToString
    @EqualsAndHashCode
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ErrorResponse implements Serializable {

        private static final long serialVersionUID = -4809150759796837940L;

        private String message;
    }
}
