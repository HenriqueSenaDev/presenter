package gov.edu.anm.presenter.model.responses;

public class LoginResponse {
    private String access_token;
    private String refresh_token;
    private String user;

    public LoginResponse(){
        
    }
    
    public LoginResponse(String access_token, String refresh_token, String user) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponse{" + "access_token=" + access_token + ", refresh_token=" + refresh_token + ", user=" + user + '}';
    }
    
}
