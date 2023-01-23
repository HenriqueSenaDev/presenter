package gov.edu.anm.presenter.domain.auth;

import gov.edu.anm.presenter.domain.appuser.AppUser;

public class AuthResponseDto {
    private String access_token;
    private String refresh_token;
    private AppUser profile;

    public AuthResponseDto(String access_token, String refresh_token, AppUser profile) {
        this.access_token = access_token;
        this.refresh_token = refresh_token;
        this.profile = profile;
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

    public AppUser getProfile() {
        return profile;
    }

    public void setProfile(AppUser profile) {
        this.profile = profile;
    }
}
