package gov.edu.anm.presenter.domain.appuser;

public class AppUserTokens {
    private String access_token;
    private String refresh_token;

    public AppUserTokens(){}
    
    public AppUserTokens(String access_token, String refresh_token) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
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

    @Override
    public String toString() {
        return "JWT{" + "access_token=" + access_token + ", refresh_token=" + refresh_token + '}';
    }
    
}
