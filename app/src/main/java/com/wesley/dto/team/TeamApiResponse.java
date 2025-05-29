package com.wesley.dto.team;

import lombok.Data;
import java.util.List;

@Data
public class TeamApiResponse {
    private String get;
    private Object parameters;
    private List<Object> errors;
    private int results;
    private Paging paging;
    private List<TeamData> response;
}