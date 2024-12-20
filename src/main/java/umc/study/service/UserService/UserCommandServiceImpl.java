//package umc.study.service.UserService;
//
//import umc.study.domain.common.User;
//import umc.study.repository.UserRepository;
//import umc.study.web.dto.UserRequestDTO;
//
//public class UserCommandServiceImpl implements UserCommandService{
//
//}





//Service 완성? (No)
//Member 객체를 만드는 작업 (클라이언트가 준 DTO to Entity)를 서비스 단에서 할까요?
//프로젝트마다 다릅니다.
//저의 경우 서비스는 오로지 비즈니스 로직에만 집중을 합니다.
//따라서 Member를 만드는 작업을 converter에서 하겠습니다.

package umc.study.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.study.converter.UserConverter;
import umc.study.converter.UserPreferConverter;

import umc.study.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.domain.common.FoodCategory;
import umc.study.domain.common.User;
import umc.study.domain.mapping.UserPreferFood;
import umc.study.repository.FoodCategoryRepository;
import umc.study.repository.UserRepository;
import umc.study.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {
        User newUser = UserConverter.toUser(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPreferFood> memberPreferList = UserPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setUser(newUser);});


        return userRepository.save(newUser);
    }
}