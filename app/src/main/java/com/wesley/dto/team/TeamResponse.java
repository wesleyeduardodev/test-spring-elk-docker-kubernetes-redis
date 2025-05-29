package com.wesley.dto.team;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeamResponse {
    private Long id;
    private Long apiId;
    private String name;
    private String code;
    private String country;
    private Integer founded;
    private Boolean national;
    private String logo;
}
