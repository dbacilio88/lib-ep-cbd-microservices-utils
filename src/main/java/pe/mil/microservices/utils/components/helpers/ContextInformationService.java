package pe.mil.microservices.utils.components.helpers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pe.mil.microservices.utils.dtos.messages.MessageResponseDto;

import java.util.List;

@Service
public class ContextInformationService {
    @Value("${ep-cdb-microservice-path:/json/microservices.codes.json}")
    private String path;
    @Value("${ep-cdb-microservice-index:01}")
    private String indexMicroservice;

    public List<MessageResponseDto> getMessageResponse() {
        DataMessageTransformJson helper = new DataMessageTransformJson();
        List<MessageResponseDto> responses = helper.loadMessageResponseJson(path);
        if (responses.isEmpty()) {
            return helper.loadDefaultMessageResponseJson();
        } else {
            return responses;
        }
    }

    public MessageResponseDto findByCodeMessage(String codeMessageResponse) {

        MessageResponseDto response = getMessageResponse()
            .stream()
            .filter(
                messageResponseDto -> messageResponseDto
                    .getCode()
                    .equals(codeMessageResponse))
            .findFirst()
            .orElse(MessageResponseDto
                .builder()
                .code("-1")
                .responseCode("-1")
                .responseMessage("code message not mapped")
                .responseHttpCode(400)
                .build()
            );

        String cod;

        if (response.getCode().equals("-1")) {
            cod = response.getResponseCode();
        } else {
            cod = response.getResponseCode().replaceFirst("xx", indexMicroservice);
        }

        response.setResponseCode(cod);

        return response;
    }

}
