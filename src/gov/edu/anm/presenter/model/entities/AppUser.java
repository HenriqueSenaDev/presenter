package gov.edu.anm.presenter.model.entities;

import java.util.List;

public class AppUser {
    private Long id;
    private String username;
    private String password;
    private List<AppRole> roles;

    public AppUser(){
        
    }

    public AppUser(Long id, String username, String password, List<AppRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(List<AppRole> roles) {
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AppUser{" + "id=" + id + ", roles=" + roles + ", username=" + username + '}';
    }
    
}

class AppRole {
    private Long id;
    private String name;
    
    public AppRole(){
        
    }

    public AppRole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AppRole{" + "id=" + id + ", name=" + name + '}';
    }
    
}
