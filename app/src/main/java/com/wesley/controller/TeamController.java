package com.wesley.controller;
import com.wesley.dto.team.TeamResponse;
import com.wesley.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{apiId}")
    public TeamResponse findOrFetchTeam(@PathVariable Long apiId) {
        return teamService.findOrFetchAndSave(apiId);
    }
}
