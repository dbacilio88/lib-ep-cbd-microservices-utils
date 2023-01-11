package pe.mil.microservices.utils.components.context;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationSession implements Serializable {

    private static final long serialVersionUID = -2783287988379842779L;

    private String userId;

    private String requestId;

    private String tenantId;
}
