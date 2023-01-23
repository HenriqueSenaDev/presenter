package gov.edu.anm.presenter.domain.team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private Long id;
    private String name;
    private String project;
    private String clasroom;
    private Double average;
    private Boolean presented;
    private List<String> members = new ArrayList<>();

    public Team(Long id, String name, String project, String clasroom, Double average,
                Boolean presented, List<String> members) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.clasroom = clasroom;
        this.average = average;
        this.presented = presented;
        this.members = members;
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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getClasroom() {
        return clasroom;
    }

    public void setClasroom(String clasroom) {
        this.clasroom = clasroom;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Boolean getPresented() {
        return presented;
    }

    public void setPresented(Boolean presented) {
        this.presented = presented;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
