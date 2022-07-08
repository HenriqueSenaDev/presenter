package gov.edu.anm.presenter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.edu.anm.presenter.mode.utils.HttpUtils;
import gov.edu.anm.presenter.model.entities.AppUser;
import gov.edu.anm.presenter.model.entities.Event;
import gov.edu.anm.presenter.model.entities.JWT;
import gov.edu.anm.presenter.model.entities.Team;
import gov.edu.anm.presenter.model.responses.LoginResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PresenterApi {

    private static final String BASE_URL = "http://localhost:8080";

    private AppUser user;
    private JWT tokens;
    private Event event;

    public void login(String username, String password)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL(BASE_URL + "/login?username=" + username + "&password=" + password);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");

        try {
            String stream = HttpUtils.getRequestInputStream(conn);
            LoginResponse loginResponse = mapper.readValue(stream, LoginResponse.class);
            JWT tokens = new JWT(loginResponse.getAccess_token(), loginResponse.getRefresh_token());
            this.tokens = tokens;
//            System.out.println(loginResponse);

            url = new URL(BASE_URL + "/api/appusers?username=" + loginResponse.getUser());
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());

            stream = HttpUtils.getRequestInputStream(conn);
            AppUser user = mapper.readValue(stream, AppUser.class);
            this.user = user;
//            System.out.println(user);
        } 
        catch (IOException e) {
            throw new RuntimeException("Erro ao realizar o login:\n" + e.getMessage());
        } 
        finally {
            conn.disconnect();
        }
    }

    public void findEvent(Integer eventCode) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        URL url = new URL(BASE_URL + "/api/events/code/" + eventCode);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());

        try {
            String stream = HttpUtils.getRequestInputStream(conn);
            Event event = mapper.readValue(stream, Event.class);
            this.event = event;
//            System.out.println(event);
        } 
        catch (IOException | IllegalArgumentException e) {
            throw new RuntimeException("Erro ao buscar event:\n" + e.getMessage());
        } 
        finally {
            conn.disconnect();
        }
    }

    public List<Team> findEventTeams() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(BASE_URL + "/api/events/teams/" + event.getId());

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());

        try {
            String stream = HttpUtils.getRequestInputStream(conn);
            List<Team> teams = mapper.readValue(stream, mapper.getTypeFactory()
                    .constructCollectionType(List.class, Team.class));
//            teams.forEach(team -> System.out.println(team));
            return teams;
        } 
        catch (IOException e) {
            throw new RuntimeException("Erro na busca das equipes:\n" + e.getMessage());
        } 
        finally {
            conn.disconnect();
        }
    }

    public List<String> findTeamMembersUsernames(Team team) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(BASE_URL + "/api/teams/members/" + team.getId());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());
        
        try {
            String stream = HttpUtils.getRequestInputStream(conn);
            List<String> usernames = mapper.readValue(stream, mapper.getTypeFactory()
                    .constructCollectionType(List.class, String.class));
//            usernames.forEach(username -> System.out.println(username));
            return usernames;
        } 
        catch (IOException e) {
            throw new IOException("Erro na busca dos integrantes da equipe:\n" + e.getMessage());
        }
        finally {
            conn.disconnect();
        }
    }

}
