package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import umc.study.domain.common.Restaurant;

import java.util.List;
import java.util.Optional;


public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>,RestaurantRepositoryCustom {
    Optional<Restaurant> findById(Long id);

    //List<Restaurant> dynamicQueryWithBooleanBuilder(String name, Float score);
}
