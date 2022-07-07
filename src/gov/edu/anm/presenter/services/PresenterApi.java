package gov.edu.anm.presenter.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import gov.edu.anm.presenter.mode.utils.HttpUtils;
import gov.edu.anm.presenter.model.entities.AppUser;
import gov.edu.anm.presenter.model.entities.JWT;
import gov.edu.anm.presenter.model.responses.LoginResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;

public class PresenterApi {
    private static final String BASE_URL = "http://localhost:8080";
    
    private AppUser user;
    private JWT tokens;

    public void login(String username, String password)
            throws IOException, InterruptedException, URISyntaxException {
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
    
    
}
