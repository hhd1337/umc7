//package umc.study.web.controller;
//
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import umc.study.apiPayload.ApiResponse;
//import umc.study.service.UserService.MissionCommandService;
//import umc.study.validation.annotation.ExistRestaurant;
//import umc.study.web.dto.MissionReqDto;
//import umc.study.web.dto.MissionResponse;
//
//@Tag(name="Mission",description = "미션 관련 API")
//@Validated
//@RequiredArgsConstructor
//@RestController
//@RequestMapping("/missions")
//public class MissionRestController {
//    private final MissionCommandService missionCommandService;
//
//    @Operation(
//            summary = "미션 만들기",
//            description = "주어진 정보를 바탕으로 가게에 미션을 생성합니다."
//    )
//    @Parameter(name = "storeId", description = "가게 Id, path variable 입니다.", example = "1")
//    @PostMapping("/{storeId}/mission")
//    public ApiResponse<MissionResponse> createMission(
//            @RequestBody @Valid MissionReqDto request,
//            @PathVariable("storeId") @ExistRestaurant Long storeId) {
//        Long memberId = 1L;
//        return ApiResponse.onSuccess(new MissionResponse(missionCommandService.createMission(request, storeId, memberId)));
//    }
//}