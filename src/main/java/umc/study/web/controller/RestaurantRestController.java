package umc.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.domain.apiPayload.ApiResponse;
import umc.study.service.UserService.ReviewCommandService;
import umc.study.validation.annotation.ExistRestaurant;
import umc.study.web.dto.ReviewReqDto;
import umc.study.web.dto.ReviewResponse;

@Tag(name="Restaurant",description = "상점, 리뷰 관련 API")
@Validated
@RestController
@RequestMapping("/Restaurants")

public class RestaurantRestController {
    private final ReviewCommandService reviewCommandService;
    public RestaurantRestController(ReviewCommandService reviewCommandService) {
        this.reviewCommandService = reviewCommandService;
    }
    @Operation(
            summary = "리뷰 작성하기",
            description = "특정 가게에 리뷰를 추가합니다."
    )
    @Parameter(name="restaurantId", description = "가게 Id, path variable 입니다.",example = "1")
    @PostMapping("/{restaurantId}/review")
    public ApiResponse<ReviewResponse> createReview(
            @PathVariable("restaurantId") @ExistRestaurant Long restaurantId,
            @RequestBody @Valid ReviewReqDto request) {
        Long memberId = 1L;
        return ApiResponse.onSuccess(new ReviewResponse(reviewCommandService.createReview(request, restaurantId, memberId)));
    }
}
