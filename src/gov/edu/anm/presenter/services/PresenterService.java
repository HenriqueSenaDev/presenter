package gov.edu.anm.presenter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.edu.anm.presenter.domain.appuser.AppUserTokens;
import gov.edu.anm.presenter.domain.auth.AuthRequestDto;
import gov.edu.anm.presenter.domain.auth.AuthResponseDto;
import gov.edu.anm.presenter.domain.auth.RefreshRequestDto;
import gov.edu.anm.presenter.domain.auth.RefreshResponseDto;
import gov.edu.anm.presenter.domain.event.Event;
import gov.edu.anm.presenter.domain.team.Team;
import gov.edu.anm.presenter.domain.team.TeamCreateDto;
import gov.edu.anm.presenter.domain.team.TeamUpdateDto;
import gov.edu.anm.presenter.domain.utils.HttpUtils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PresenterService {
    private final HttpClient httpClient;
    private final ObjectMapper mapper;

    private static final String API_HOST = System.getenv("API_HOST");
    private static final String BASE_URL = API_HOST + "/api/admin";

    public PresenterService(HttpClient httpClient, ObjectMapper mapper) {
        this.httpClient = httpClient;
        this.mapper = mapper;
    }

    public AuthResponseDto authenticate(String username, String password) throws RuntimeException {
        try {
            var authBody = new AuthRequestDto(username, password);
            HttpRequest req = HttpUtils.createPostRequest(URI.create(API_HOST + "/api/auth/authenticate"), authBody, mapper);

            HttpResponse<String> res = this.httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(res.body(), AuthResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao realizar login:\n" + e.getMessage());
        }
    }

    public RefreshResponseDto refreshToken(String refresh_token) throws RuntimeException {
        try {
            var refreshBody = new RefreshRequestDto(refresh_token);
            HttpRequest req = HttpUtils.createPostRequest(URI.create(API_HOST + "/api/auth/refresh"), refreshBody, mapper);

            HttpResponse<String> res = this.httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(res.body(), RefreshResponseDto.class);
        }
        catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar sessão:\n" + e.getMessage());
        }
    }

    public Event findEventByJoinCode(String eventJoinCode, AppUserTokens tokens) throws RuntimeException {
        try {
            HttpRequest req = HttpUtils.createGetRequestWithBearerAuth(URI.create(BASE_URL + "/events/code/" + eventJoinCode), tokens.getAccess_token());

            HttpResponse<String> res = this.httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(res.body(), Event.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar evento:\n" + e.getMessage());
        }
    }

    public Event createTeamInEvent(TeamCreateDto teamCreateDto, Long eventId, AppUserTokens tokens) throws RuntimeException {
        try {
            HttpRequest req = HttpUtils.createPostRequestWithBearerAuth(URI.create(BASE_URL + "/events/" + eventId + "/teams"), teamCreateDto, tokens.getAccess_token(), mapper);

            HttpResponse<String> res = this.httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(res.body(), Event.class);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar equipe:\n" + e.getMessage());
        }
    }

    public Team updateTeam(TeamUpdateDto teamUpdateDto, Long teamId, AppUserTokens tokens) throws Exception {
        try {
            HttpRequest req = HttpUtils.createPutRequestWithBearerAuth(URI.create(BASE_URL + "/teams/" + teamId), teamUpdateDto, tokens.getAccess_token(), mapper);

            HttpResponse<String> res = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
            return mapper.readValue(res.body(), Team.class);
        } catch (Exception e) {
            throw new Exception("Erro ao atualizar equipe:\n" + e.getMessage());
        }
    }

    public void deleteTeam(Long teamId, AppUserTokens tokens) throws RuntimeException {
        try {
            HttpRequest req = HttpUtils.createDeleteRequestWithBearerAuth(URI.create(BASE_URL + "/teams/" + teamId), tokens.getAccess_token());

            this.httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao excluir a equipe:\n" + e.getMessage());
        }
    }

}
