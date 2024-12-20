package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.ReviewConverter;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.UserHandler;
import umc.study.domain.common.Restaurant;
import umc.study.domain.common.User;
import umc.study.domain.mapping.Review;
import umc.study.repository.RestaurantRepository;
import umc.study.repository.ReviewRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.ReviewReqDto;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    private final ReviewRepository reviewRepository;
    private final UserRepository memberRepository;
    private final RestaurantRepository storeRepository;
    @Override
    @Transactional
    public Review createReview(ReviewReqDto request, Long storeId, Long memberId) {
        User requestMember = memberRepository.findById(memberId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Restaurant restaurant = storeRepository.findById(storeId).get();
        Review newReview =  ReviewConverter.toReview(requestMember, request, restaurant);
        restaurant.getReviewList().add(newReview);
        requestMember.getReviewList().add(newReview);
        return reviewRepository.save(newReview);
    }

}
