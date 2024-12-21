package umc.study.converter;

import umc.study.domain.common.User;
import umc.study.domain.enums.Gender;
import umc.study.web.dto.UserRequestDTO;
import umc.study.web.dto.UserResponseDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(User user){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE; //성별 미지정. 사용자 친화적인 구현 위해 이런 방법도 쓴다고함.
                break;
        }

        return User.builder()
                .address(request.getAddress()) // 주소 설정
                .gender(gender) // 성별 설정
                .name(request.getName()) // 이름 설정
                .email(request.getEmail())   // 추가된 코드
                .nickname(request.getNickname())  // 닉네임 추가
                .password(request.getPassword())   // 추가된 코드
                .birthdate(LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDay())) // 생년월일 설정
                .userPreferFoods(new ArrayList<>()) // 사용자 선호 음식 리스트 초기화
                .reviews(new ArrayList<>()) // 리뷰 리스트 초기화
                .missionProgressList(new ArrayList<>()) // 미션 진행 리스트 초기화
                .role(request.getRole())   // 추가된 코드
                .notifications(new ArrayList<>()) // 알림 리스트 초기화
                .build();
    }
}
