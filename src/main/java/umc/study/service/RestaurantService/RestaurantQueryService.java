package umc.study.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.study.domain.common.Mission;
import umc.study.domain.mapping.Review;
import umc.study.domain.common.Restaurant;

import java.util.List;

import java.util.List;

public interface RestaurantQueryService {
    List<Restaurant> findRestaurantsByNameAndScore(String name, Float score);
    boolean restaurantExist(Long restaurantId);
    Page<Mission> getMissionList(Long restaurantId, Integer page);
}