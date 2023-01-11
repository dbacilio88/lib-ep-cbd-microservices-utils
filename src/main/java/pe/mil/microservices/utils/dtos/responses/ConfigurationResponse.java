package pe.mil.microservices.utils.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import pe.mil.microservices.utils.dtos.commons.CommonApplicationInfo;
import pe.mil.microservices.utils.dtos.process.ConfigurationProcess;

import java.io.Serializable;

@Data
@Builder
@ToString()
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConfigurationResponse implements Serializable {

    private static final long serialVersionUID = -1602841362488322859L;

    private ConfigurationProcess configurationProcess;
    private CommonApplicationInfo commonApplicationInfo;

}
