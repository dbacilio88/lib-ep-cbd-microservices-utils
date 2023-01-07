package pe.mil.microservices.utils.dtos.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.Date;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@SuppressFBWarnings(value = {"EI_EXPOSE_REP2", "EI_EXPOSE_REP"}, justification = "Skip by builder, constructor, field")
public class BaseBusinessResponseDto implements Serializable {

    private static final long serialVersionUID = 6955339020122289312L;
    @JsonbProperty(value = "code")
    @JsonProperty(value = "code")
    String messageResponseCode;
    @JsonbProperty(value = "message")
    @JsonProperty(value = "message")
    String messageResponse;
    @JsonbProperty(value = "datetime")
    @JsonProperty(value = "datetime")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    @JsonbDateFormat(value = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    Date dateTransaction;

}
