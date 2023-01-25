package pe.mil.microservices.utils.dtos.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pe.mil.microservices.utils.dtos.responses.MetadataResponse;

import javax.json.bind.annotation.JsonbProperty;


@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageableBusinessResponse<T> extends BaseBusinessResponseDto {

    private static final long serialVersionUID = -8286180029066337763L;

    @JsonbProperty("data")
    @JsonProperty("data")
    private T data;
    @JsonbProperty("metadata")
    @JsonProperty("metadata")
    private MetadataResponse metadata;
}
