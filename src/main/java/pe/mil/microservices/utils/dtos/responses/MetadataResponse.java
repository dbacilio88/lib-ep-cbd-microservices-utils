package pe.mil.microservices.utils.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MetadataResponse implements Serializable {

    private static final long serialVersionUID = -3292274632729437508L;

    private PageableResponse pageable;
}
