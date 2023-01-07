package pe.mil.microservices.utils.dtos.messages;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class MessageResponseDto implements Serializable {

    private static final long serialVersionUID = 1117283730142943908L;

    String code;
    String responseCode;
    String responseMessage;
    Integer responseHttpCode;
}
