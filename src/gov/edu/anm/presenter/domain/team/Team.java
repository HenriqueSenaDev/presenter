package gov.edu.anm.presenter.domain.team;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team {
    private Long id;
    private String name;
    private String project;
    private String classroom;
    private Double average;
    private Boolean presented;
    private Integer avaliationsQuantity;
    private List<String> members = new ArrayList<>();

    public Team(){}

    public Team(Long id, String name, String project, String classroom, Double average,
                Boolean presented, Integer avaliationsQuantity, List<String> members) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.classroom = classroom;
        this.average = average;
        this.presented = presented;
        this.avaliationsQuantity = avaliationsQuantity;
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

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
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

    public Integer getAvaliationsQuantity() {
        return avaliationsQuantity;
    }

    public void setAvaliationsQuantity(Integer avaliationsQuantity) {
        this.avaliationsQuantity = avaliationsQuantity;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getMembersToString() {
        if (this.members.size() == 1) return this.members.get(0) + ".";

        Optional<String> membersToString = this.members.stream()
                .reduce((a, b) -> a + ", " + b);
        return membersToString.map(s -> s + ".").orElse("");
    }
}
