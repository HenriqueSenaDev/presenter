package gov.edu.anm.presenter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.edu.anm.presenter.mode.utils.HttpUtils;
import gov.edu.anm.presenter.model.entities.AppUser;
import gov.edu.anm.presenter.model.entities.Event;
import gov.edu.anm.presenter.model.entities.JWT;
import gov.edu.anm.presenter.model.entities.Team;
import gov.edu.anm.presenter.model.responses.LoginResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
            throw new RuntimeException("Erro na busca dos integrantes da equipe:\n" + e.getMessage());
        }
        finally {
            conn.disconnect();
        }
    }

    public Team saveTeam(Team team) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        URL url = new URL(BASE_URL + "/api/teams");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        
        String customJSONString = 
                    "{" +
                        "\"name\": \"" + team.getName() + "\", " +
                        "\"project\": \"" + team.getProject() + "\", " +
                        "\"classRoom\": \"" + team.getClassRoom() + "\"" +
                    "}";
        
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = customJSONString.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            String stream = HttpUtils.getRequestInputStream(conn);
            Team savedTeam = mapper.readValue(stream, Team.class);
//            System.out.println(savedTeam);
            return savedTeam;
        }
        catch (IOException e) {
            throw new RuntimeException("Erro ao salvar equipe:\n" + e.getMessage());
        }
        finally {
            conn.disconnect();
        }
    }
    
    public List<AppUser> saveAppUsers(List<String> usernames) throws IOException {
        List<AppUser> savedUsers = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        
        URL url = new URL(BASE_URL + "/api/appusers/saveAll");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setDoOutput(true);
        
        String bodyJSON = "[";
        for (String username : usernames) {
            bodyJSON += "{" +
                            "\"username\": \"" + username + "\", " +
                            "\"password\": " + "\"testpassforstudent\"" +
                        "}, ";
        }
        bodyJSON = bodyJSON.substring(0, bodyJSON.length() - 2) + "]";
//        System.out.println(bodyJSON);
        
        try(OutputStream os = conn.getOutputStream()) {
            byte[] input = bodyJSON.getBytes("utf-8");
            os.write(input, 0, input.length);
            
            String stream = HttpUtils.getRequestInputStream(conn);
//            System.out.println(stream);
            if (stream.contains("is already in use")) {
                String existingUser = 
                        stream.replace("{\"error_message\":\"Request processing failed; nested exception is java.lang.RuntimeException: The username ", "")
                              .replace(" is already in use.\"}", "");
                throw new IOException("O nome de usuário " + existingUser + " já está em uso.");
            } 
            else {
                savedUsers = mapper.readValue(stream, mapper.getTypeFactory()
                        .constructCollectionType(List.class, AppUser.class));
            }
            return savedUsers;
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Erro ao salvar usuários:\n" + e.getMessage());
        }
        finally {
            conn.disconnect();
        }
    }
    
    public void deleteTeam(Long id) throws IOException {
        URL url = new URL(BASE_URL + "/api/teams/" + id);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("DELETE");
        conn.setRequestProperty("Authorization", "Bearer " + tokens.getAccess_token());
        
        try {
            String stream = HttpUtils.getRequestInputStream(conn);
            System.out.println(stream);
        } 
        catch (IOException e) {
            throw new RuntimeException("Erro ao excluir a equipe:\n" + e.getMessage());
        }
        finally {
            conn.disconnect();
        }
    }
    
}
