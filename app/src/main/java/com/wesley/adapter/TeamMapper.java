package com.wesley.adapter;

import com.wesley.dto.team.TeamResponse;
import com.wesley.dto.team.TeamResponseClient;
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
                .apiId(team.getApiId())
                .name(team.getName())
                .code(team.getCode())
                .country(team.getCountry())
                .founded(team.getFounded())
                .national(team.getNational())
                .logo(team.getLogo())
                .build();
    }

    public static Team toEntity(TeamResponseClient dto) {
        return Team.builder()
                .apiId(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .country(dto.getCountry())
                .founded(dto.getFounded())
                .national(dto.getNational())
                .logo(dto.getLogo())
                .build();
    }
}
