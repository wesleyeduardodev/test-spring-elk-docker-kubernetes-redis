package com.wesley.service;
import com.wesley.adapter.TeamMapper;
import com.wesley.dto.team.TeamResponse;
import com.wesley.entity.Team;
import com.wesley.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamCacheService {

    private final TeamRepository repository;

    @Cacheable(value = "team", key = "#apiId")
    public TeamResponse findTeam(Long apiId) {

        log.info("[Cache MISS] Buscando time com ID externo '{}' no banco", apiId);

        Optional<Team> byApiId = repository.findByApiId(apiId);

        if (byApiId.isPresent()) {
            log.info("[Cache HIT] Time encontrado no cache/banco: {}", byApiId.get().getName());
            return TeamMapper.toDTO(byApiId.get());
        } else {
            return null;
        }
    }
}
