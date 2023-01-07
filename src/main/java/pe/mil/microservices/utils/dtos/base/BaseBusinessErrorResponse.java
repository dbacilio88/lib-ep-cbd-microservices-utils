package pe.mil.microservices.utils.dtos.base;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.mil.microservices.utils.dtos.errors.BaseErrorResponse;

import java.io.Serializable;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@SuppressFBWarnings(value = "EI_EXPOSE_REP2", justification = "This code stores a reference to an externally mutable object into the internal representation of the object")
public class BaseBusinessErrorResponse extends BaseBusinessResponseDto implements Serializable {

    private static final long serialVersionUID = 5193331350313534199L;
    private BaseErrorResponse data;
}
