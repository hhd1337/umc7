package umc.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import umc.study.domain.mapping.Review;
import umc.study.service.UserService.ReviewCommandService;
import umc.study.web.dto.ReviewReqDto;

@Configuration
public class AppConfig {

    @Bean
    public ReviewCommandService reviewCommandService() {
        return new ReviewCommandService() {
            @Override
            public Review createReview(ReviewReqDto request, Long storeId, Long memberId) {
                return null;
            }
        };
    }
}
