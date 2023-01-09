package pe.mil.microservices.utils.dtos.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pe.mil.microservices.utils.components.helpers.ContextInformationService;
import pe.mil.microservices.utils.dtos.errors.BaseErrorDetailResponse;
import pe.mil.microservices.utils.dtos.errors.BaseErrorResponse;
import pe.mil.microservices.utils.dtos.messages.MessageResponseDto;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Validated
public class BusinessResponse {
    private static final Logger logger = LogManager.getLogger(BusinessResponse.class);
    private final ContextInformationService contextInformationService;

    public BusinessResponse(ContextInformationService contextInformationService) {
        this.contextInformationService = contextInformationService;
    }

    public ResponseEntity<Object> getResponse(@NotNull String codeMessageResponse) {
        return getResponse(BaseBusinessResponseDto.builder().build(), codeMessageResponse);
    }

    public ResponseEntity<Object> getResponse(BaseBusinessResponseDto baseResponse, @NotNull String codeMessageResponse) {

        try (Jsonb jsonb = JsonbBuilder.create()) {
            MessageResponseDto response = this.contextInformationService.findByCodeMessage(codeMessageResponse);
            baseResponse.dateTransaction = new Date();
            baseResponse.messageResponseCode = response.getResponseCode();
            baseResponse.messageResponse = response.getResponseMessage();
            HttpStatus httpStatus = HttpStatus.valueOf(response.getResponseHttpCode());
            String body = jsonb.toJson(baseResponse);
            return new ResponseEntity<>(body, httpStatus);

        } catch (Exception e) {
            logger.error("error general parsed object", e);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Object> getResponse(BaseBusinessResponseDto baseResponse, @NotNull String codeMessageResponse, HttpHeaders headers) {

        try (Jsonb jsonb = JsonbBuilder.create()) {
            MessageResponseDto response = this.contextInformationService.findByCodeMessage(codeMessageResponse);
            baseResponse.dateTransaction = new Date();
            baseResponse.messageResponseCode = response.getResponseCode();
            baseResponse.messageResponse = response.getResponseMessage();
            HttpStatus httpStatus = HttpStatus.valueOf(response.getResponseHttpCode());
            String body = jsonb.toJson(baseResponse);
            return new ResponseEntity<>(body, headers, httpStatus);

        } catch (Exception e) {
            logger.error("error general parsed object", e);
        }

        return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getResponse(@NotNull String codeMessageResponse, @NotNull List<BaseErrorDetailResponse> baseErrorDetailResponses) {

        try (Jsonb jsonb = JsonbBuilder.create()) {

            MessageResponseDto response = this.contextInformationService.findByCodeMessage(codeMessageResponse);
            BaseBusinessErrorResponse errorResponse = BaseBusinessErrorResponse.builder()
                .messageResponseCode(response.getResponseCode())
                .messageResponse(response.getResponseMessage())
                .dateTransaction(new Date())

                .data(BaseErrorResponse.builder()
                    .errors(baseErrorDetailResponses.stream()
                        .filter(messageTypeErrorGroup -> messageTypeErrorGroup.getGroupResponseCode()
                            .getResponseCodeGroup().contains(codeMessageResponse))
                        .map(messageErrorDetail ->
                            !messageErrorDetail.getAdditionalMessage().isPresent()
                                ? BaseErrorResponse.ErrorResponse.builder()
                                .message(
                                    messageErrorDetail
                                        .getGroupResponseCode()
                                        .getResponseCodeMessage()
                                ).build()
                                : BaseErrorResponse
                                .ErrorResponse.builder()
                                .message(
                                    String
                                        .format(
                                            messageErrorDetail
                                                .getGroupResponseCode()
                                                .getResponseCodeMessage(),
                                            messageErrorDetail
                                                .getAdditionalMessage()
                                                .get()))
                                .build()
                        ).collect(Collectors.toList())
                    ).build()).build();


            HttpStatus httpStatus = HttpStatus.valueOf(response.getResponseHttpCode());
            String body = jsonb.toJson(errorResponse);
            jsonb.close();
            return new ResponseEntity<>(body, httpStatus);

        } catch (Exception e) {
            logger.error("error general parsed object", e);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
