package com.wesley.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class TeamApiResponse {
    private List<TeamWrapper> response;

    @Data
    public static class TeamWrapper {
        private TeamResponse team;
    }
}