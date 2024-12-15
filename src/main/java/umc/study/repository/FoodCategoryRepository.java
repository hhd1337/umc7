package umc.study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.domain.common.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
