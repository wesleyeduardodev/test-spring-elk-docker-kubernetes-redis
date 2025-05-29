package com.wesley.api;
import com.wesley.config.ApiFootballConfig;
import com.wesley.dto.TeamApiResponse;
import com.wesley.dto.TeamResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApiFootballClient {

    private final ApiFootballConfig config;
    private final RestTemplate restTemplate;

    public TeamResponse fetchTeamById(String id) {

        String url = config.getBaseUrl() + "/teams?id=" + id;
        log.info("Requesting team from API-Football: {}", id);

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-apisports-key", config.getApiKey());

            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

            ResponseEntity<TeamApiResponse> response = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    requestEntity,
                    TeamApiResponse.class
            );

            if (response.getBody() == null) {
                throw new IllegalStateException("API-Football response body is null for team ID: " + id);
            }

            if (response.getBody().getResponse() == null || response.getBody().getResponse().isEmpty()) {
                throw new IllegalStateException("API-Football returned empty team list for team ID: " + id);
            }

            log.info("Successfully fetched team: {}", response.getBody().getResponse().get(0).getTeam().getName());
            return response.getBody().getResponse().get(0).getTeam();

        } catch (RestClientException e) {
            log.error("Error during API-Football call for team ID {}: {}", id, e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("Unexpected error while calling API-Football for team ID {}: {}", id, e.getMessage(), e);
            throw e;
        }
    }
}
