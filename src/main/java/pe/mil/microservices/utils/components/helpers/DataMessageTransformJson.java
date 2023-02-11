package pe.mil.microservices.utils.components.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pe.mil.microservices.utils.dtos.messages.MessageResponseDto;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressFBWarnings(value = {"SIC_INNER_SHOULD_BE_STATIC_ANON", "DM_NEW_FOR_GETCLASS"}, justification = "Skip by conversion explicit object")
public class DataMessageTransformJson {

    private static final Logger logger = LogManager.getLogger(DataMessageTransformJson.class);

    public List<MessageResponseDto> loadMessageResponseJson(String path) {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<MessageResponseDto>> typeReference = new TypeReference<List<MessageResponseDto>>() {
        };
        try (InputStream stream = TypeReference.class.getResourceAsStream(path)) {
            return mapper.readValue(stream, typeReference);
        } catch (IOException e) {
            logger.error("error in loadMessageResponseJson {}", e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<MessageResponseDto> loadDefaultMessageResponseJson() {

        String json = "[{\"code\":\"000\", \"responseCode\":\"200.01.000\",\"responseMessage\":\"Process Ok\", \"responseHttpCode\":\"200\"},{\"code\":\"001\",\"responseCode\":\"400.01.001\",\"responseMessage\":\"Header Params Required\",\"responseHttpCode\":\"400\"},{\"code\":\"002\",\"responseCode\":\"400.01.002\",\"responseMessage\":\"JWE Invalid format\",\"responseHttpCode\":\"400\"}]";

        try (Jsonb jsonb = JsonbBuilder.create()) {
            return jsonb.fromJson(json, new ArrayList<MessageResponseDto>() {
                private static final long serialVersionUID = 5821672982184062787L;
            }.getClass().getGenericSuperclass());
        } catch (Exception e) {
            logger.error("error in load default message response process {} ", e.getMessage());
        }

        return Collections.emptyList();
    }
}