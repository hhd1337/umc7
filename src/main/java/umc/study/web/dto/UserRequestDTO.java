//package umc.study.web.dto;
//
//import lombok.Getter;
//
//import java.util.List;
//
//public class UserRequestDTO {
//
//    @Getter
//    public static class JoinDto{
//        String name;
//        Integer gender;
//        Integer birthYear;
//        Integer birthMonth;
//        Integer birthDay;
//        String address;
//        List<Long> preferCategory;
//    }
//}
package umc.study.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.study.domain.enums.Role;
import umc.study.validation.annotation.ExistCategories;

import java.util.ArrayList;
import java.util.List;

public class UserRequestDTO {

    @Getter
    @Setter
    public static class JoinDto {

        @NotBlank(message = "이름은 필수 입력 값입니다.")
        private String name;

        @NotBlank(message = "닉네임은 필수 입력 값입니다.")
        private String nickname;

        @NotNull(message = "성별은 필수 입력 값입니다.")
        private Integer gender;

        @NotNull(message = "생년은 필수 입력 값입니다.")
        private Integer birthYear;

        @NotNull(message = "생월은 필수 입력 값입니다.")
        private Integer birthMonth;

        @NotNull(message = "생일은 필수 입력 값입니다.")
        private Integer birthDay;
        @Size(min = 5, max = 12)
        private String address;

        private String phone;
        @NotBlank
        @Email
        String email;    // 이메일 필드 추가
        @NotBlank
        String password;    // 비밀번호 필드 추가
        @NotNull
        Role role;    // 역할 필드 추가

        @ExistCategories
        private List<Long> preferCategory= new ArrayList<>(); // 선호 카테고리 리스트
    }
}
