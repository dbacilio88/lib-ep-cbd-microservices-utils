package pe.mil.microservices.utils.components.context;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppSessionContext implements Serializable {

    private static final long serialVersionUID = -4012185970492543320L;

    ApplicationSession applicationSession;
}
