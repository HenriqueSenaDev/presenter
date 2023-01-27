package gov.edu.anm.presenter.domain.appuser;

public class AppUser {
    private Long id;
    private String username;
    private AppRole role;

    public AppUser(){}

    public AppUser(Long id, String username, AppRole role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        this.role = role;
    }
}
