package com.wesley.service;
import com.wesley.adapter.TeamMapper;
import com.wesley.api.ApiFootballClient;
import com.wesley.dto.team.TeamResponse;
import com.wesley.entity.Team;
import com.wesley.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository repository;
    private final ApiFootballClient client;

    public TeamResponse findOrFetchAndSave(String code) {

        Optional<Team> existingTeam = repository.findByCode(code.toUpperCase());

        if (existingTeam.isPresent()) {
            return TeamMapper.toDTO(existingTeam.get());
        }

        TeamResponse apiTeam = client.fetchTeamById("33");

        Team teamToSave = TeamMapper.toEntity(apiTeam);

        repository.save(teamToSave);

        return apiTeam;
    }
}
