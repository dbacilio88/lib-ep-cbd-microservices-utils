package pe.mil.microservices.utils.dtos.messages;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessageBusinessResponse implements Serializable {

    private static final long serialVersionUID = -8670658213544866664L;

    @Builder.Default
    private List<String> messageBusiness = Collections.emptyList();
}
