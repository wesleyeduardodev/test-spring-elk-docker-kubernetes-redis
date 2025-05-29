package com.wesley.service;
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

    @Cacheable(value = "teams", key = "#apiId")
    public Optional<Team> findTeam(Long apiId) {
        log.info("[Cache MISS] Buscando time com ID externo '{}' no banco", apiId);
        return repository.findByApiId(apiId);
    }
}
