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

    @GetMapping("/{code}")
    public TeamResponse findOrFetchTeam(@PathVariable String code) {
        return teamService.findOrFetchAndSave(code);
    }
}
