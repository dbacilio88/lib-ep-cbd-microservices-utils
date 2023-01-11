package pe.mil.microservices.utils.dtos.process;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@ToString()
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationProcess implements Serializable {
    private static final long serialVersionUID = 8823870824949983339L;
    private String name;
    private String state;
}
