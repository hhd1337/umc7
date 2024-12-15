package umc.study.converter;

import umc.study.domain.common.FoodCategory;
import umc.study.domain.mapping.UserPreferFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserPreferConverter {
    public static List<UserPreferFood> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserPreferFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
