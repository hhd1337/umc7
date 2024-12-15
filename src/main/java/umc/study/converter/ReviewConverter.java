package umc.study.converter;


import org.springframework.data.domain.Page;
import umc.study.domain.common.Restaurant;
import umc.study.domain.common.User;
import umc.study.domain.mapping.Review;
import umc.study.web.dto.ReviewListResponse;
import umc.study.web.dto.ReviewReqDto;
import umc.study.web.dto.ReviewResponse;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {
    public static Review toReview(User requestMember, ReviewReqDto request, Restaurant restaurant){
        return Review.builder()
                .reviewText(request.getContent())
                .starRating(request.getScore())
                .user(requestMember)
                .restaurant(restaurant)
                .build();
    }

    public static ReviewListResponse toReviewListResponse(Page<Review> reviewList) {
        List<ReviewResponse> reviewResponse = reviewList.stream()
                .map(ReviewResponse::new).collect(Collectors.toList());

        return ReviewListResponse.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalElements(reviewList.getTotalElements())
                .totlaPage(reviewList.getTotalPages())
                .listSize(reviewList.getSize())
                .reviewList(reviewResponse)
                .build();
    }
}
