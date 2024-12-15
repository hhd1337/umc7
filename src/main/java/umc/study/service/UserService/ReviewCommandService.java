package umc.study.service.UserService;


import org.springframework.stereotype.Service;
import umc.study.domain.mapping.Review;
import umc.study.web.dto.ReviewReqDto;

@Service
public interface ReviewCommandService {
    Review createReview(ReviewReqDto request, Long storeId, Long memberId);
}
