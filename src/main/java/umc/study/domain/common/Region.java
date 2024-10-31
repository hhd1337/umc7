package umc.study.domain.common;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", length = 30, nullable = false)
    private String city;

    @Column(name = "district", length = 30, nullable = false)
    private String district;

    @Column(name = "subdistrict", length = 30, nullable = false)
    private String subdistrict;

    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
    private List<Restaurant> restaurants = new ArrayList<>();
}
