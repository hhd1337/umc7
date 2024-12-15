package umc.study.web.dto;


import lombok.*;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReviewListResponse {
    private List<ReviewResponse> reviewList;
    private int listSize;
    private int totlaPage;
    private Long totalElements;
    private Boolean isFirst;
    private Boolean isLast;

}
