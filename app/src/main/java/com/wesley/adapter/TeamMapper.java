package com.wesley.adapter;

import com.wesley.dto.TeamResponse;
import com.wesley.entity.Team;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.UtilityClass;

@Data
@Builder
@UtilityClass
public class TeamMapper {

    public static TeamResponse toDTO(Team team) {
        return TeamResponse.builder()
                .id(team.getId())
                .name(team.getName())
                .code(team.getCode())
                .country(team.getCountry())
                .founded(team.getFounded())
                .national(team.getNational())
                .logo(team.getLogo())
                .build();
    }

    public static Team toEntity(TeamResponse dto) {
        return Team.builder()
                .id(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .country(dto.getCountry())
                .founded(dto.getFounded())
                .national(dto.getNational())
                .logo(dto.getLogo())
                .build();
    }
}
