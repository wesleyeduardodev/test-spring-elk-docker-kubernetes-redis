package com.wesley.dto.team;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TeamResponseClient {
    private Long id;
    private String name;
    private String code;
    private String country;
    private Integer founded;
    private Boolean national;
    private String logo;
}