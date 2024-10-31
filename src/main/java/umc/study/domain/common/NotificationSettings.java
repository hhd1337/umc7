package umc.study.domain.common;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NotificationSettings extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "receive_mission_notifications", nullable = false)
    private Boolean receiveMissionNotifications;

    @Column(name = "receive_review_reply_notifications", nullable = false)
    private Boolean receiveReviewReplyNotifications;

    @Column(name = "receive_inquiry_reply_notifications", nullable = false)
    private Boolean receiveInquiryReplyNotifications;
}
