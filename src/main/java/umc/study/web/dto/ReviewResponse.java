package umc.study.web.dto;

import lombok.*;
import umc.study.domain.mapping.Review;


import java.time.LocalDateTime;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ReviewResponse {
    private Long id;
    private String content;
    private Float score;
    private String reviewOwner;
    private LocalDateTime createdAt;

    public ReviewResponse(Review review) {
        this.id = review.getId();
        this.content = review.getReviewText();
        this.score = review.getStarRating().floatValue();
        this.reviewOwner = review.getUser().getName();
        this.createdAt = review.getCreatedAt();
    }
}
