package gov.edu.anm.presenter.domain.event;

import gov.edu.anm.presenter.domain.team.Team;

import java.util.HashSet;
import java.util.Set;

public class Event {
    private Long id;
    private String name;
    private String joinCode;
    private String jurorCode;
    private String description;
    private Set<Team> teams = new HashSet<>();

    public Event(){}

    public Event(Long id, String name, String joinCode, String jurorCode, String description, Set<Team> teams) {
        this.id = id;
        this.name = name;
        this.joinCode = joinCode;
        this.jurorCode = jurorCode;
        this.description = description;
        this.teams = teams;
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

    public String getJoinCode() {
        return joinCode;
    }

    public void setJoinCode(String joinCode) {
        this.joinCode = joinCode;
    }

    public String getJurorCode() {
        return jurorCode;
    }

    public void setJurorCode(String jurorCode) {
        this.jurorCode = jurorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }
}
