package umc.study.domain.common;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;
import umc.study.domain.common.Inquiry;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class InquiryReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id", nullable = false)
    private Inquiry inquiry;

    @Column(name = "content", columnDefinition = "TEXT", nullable = false)
    private String content;

}
