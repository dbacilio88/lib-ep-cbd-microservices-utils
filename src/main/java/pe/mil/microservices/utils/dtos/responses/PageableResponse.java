package pe.mil.microservices.utils.dtos.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageableResponse implements Serializable {

    private static final long serialVersionUID = 8012439245922176849L;

    private String total;
    private String limit;
    private String currentPage;
    private String totalPages;
    private String numberOfElements;
    private String size;
    private String number;
    private String lastPage;
    private String firstPageUrl;
    private String lastPageUrl;
    private String nextPageUrl;
    private String prevPageUrl;
    private String from;
    private String to;
}
