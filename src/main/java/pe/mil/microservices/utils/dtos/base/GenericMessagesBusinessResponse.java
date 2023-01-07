package pe.mil.microservices.utils.dtos.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pe.mil.microservices.utils.dtos.messages.MessageBusinessResponse;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;


@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GenericMessagesBusinessResponse extends BaseBusinessResponseDto implements Serializable {

    private static final long serialVersionUID = -8286180029066337763L;

    @JsonbProperty("data")
    @JsonProperty("data")
    private MessageBusinessResponse messageBusinessResponse;
}
