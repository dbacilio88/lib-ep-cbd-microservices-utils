package pe.mil.microservices.utils.dtos.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenericBusinessResponse<T> extends BaseBusinessResponseDto implements Serializable {

    private static final long serialVersionUID = -8286180029066337763L;

    @JsonbProperty("data")
    @JsonProperty("data")
    private T data;
}
