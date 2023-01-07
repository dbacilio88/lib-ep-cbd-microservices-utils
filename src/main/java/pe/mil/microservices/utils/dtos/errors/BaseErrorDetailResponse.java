package pe.mil.microservices.utils.dtos.errors;

import lombok.*;
import pe.mil.microservices.utils.components.enums.GroupResponseCode;
import java.util.Optional;

@Data
@Builder
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorDetailResponse {

    private GroupResponseCode groupResponseCode;

    @Builder.Default
    private Optional<String> additionalMessage = Optional.empty();
}
