package gov.edu.anm.presenter.domain.auth;

public class RefreshRequestDto {
    private String refresh_token;

    public RefreshRequestDto(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
