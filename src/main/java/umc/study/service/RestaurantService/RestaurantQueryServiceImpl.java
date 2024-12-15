package umc.study.service.RestaurantService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.domain.common.Mission;
import umc.study.domain.common.Restaurant;
import umc.study.repository.MissionRepository;
import umc.study.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService {
    private final RestaurantRepository restaurantRepository;
    private final MissionRepository missionRepository;

    @Override
    public List<Restaurant> findRestaurantsByNameAndScore(String name, Float score) {
        List<Restaurant> filterdRestaurants = restaurantRepository.dynamicQueryWithBooleanBuilder(name, score);
        filterdRestaurants.forEach(restaurant -> System.out.println("Restaurant : "+restaurant));
        return filterdRestaurants;
    }

    @Override
    public boolean restaurantExist(Long restaurantId) {
        return restaurantRepository.existsById(Math.toIntExact(restaurantId));
    }

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return (Page<Mission>) missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));
    }
}