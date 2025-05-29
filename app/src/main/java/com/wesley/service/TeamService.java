package com.wesley.service;
import com.wesley.adapter.TeamMapper;
import com.wesley.api.ApiFootballClient;
import com.wesley.dto.team.TeamResponse;
import com.wesley.dto.team.TeamResponseClient;
import com.wesley.entity.Team;
import com.wesley.exception.BusinessException;
import com.wesley.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamService {

    private final ApiFootballClient apiClient;

    private final TeamRepository teamRepository;

    private final TeamCacheService teamCacheService;

    public TeamResponse findOrFetchAndSave(Long apiId) {
        log.info("Iniciando busca do time com código '{}'", apiId);
        Optional<Team> existingTeam = teamCacheService.findTeam(apiId);
        if (existingTeam.isPresent()) {
            log.info("[Cache HIT] Time encontrado no cache/banco: {}", existingTeam.get().getName());
            return TeamMapper.toDTO(existingTeam.get());
        } else {
            return fetchAndSaveFromApi(apiId);
        }
    }

    private TeamResponse fetchAndSaveFromApi(final Long apiTeamId) {
        try {

            log.info("[Cache MISS] Buscando time na API externa com ID '{}'", apiTeamId);

            final TeamResponseClient apiTeam = apiClient.fetchTeamById(apiTeamId);

            if (apiTeam == null) {
                final String message = "Time não encontrado na API externa com ID: " + apiTeamId;
                log.warn(message);
                throw new BusinessException(message);
            }

            final Team teamEntity = TeamMapper.toEntity(apiTeam);

            teamRepository.save(teamEntity);

            log.info("Time '{}' salvo com sucesso no banco de dados", teamEntity.getName());

            return TeamMapper.toDTO(teamEntity);
        } catch (Exception ex) {
            log.error("Erro ao buscar/salvar time com ID '{}': {}", apiTeamId, ex.getMessage(), ex);
            throw ex;
        }
    }
}
