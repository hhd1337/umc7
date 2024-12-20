package umc.study.web.dto;


import lombok.*;
import umc.study.domain.common.Mission;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class MissionResponse {
    private Long id;
    private String content;
    private String storeName;
    private Integer reword;
    private LocalDate deadline;

    public MissionResponse(Mission mission) {
        this.id = mission.getId();
        this.storeName = mission.getRestaurant().getName();
        this.content = mission.getMission();
        this.reword = mission.getPointsReward();
        this.deadline = mission.getDDay();
    }
}
