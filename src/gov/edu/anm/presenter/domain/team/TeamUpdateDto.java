package gov.edu.anm.presenter.domain.team;

import java.util.ArrayList;
import java.util.List;

public class TeamUpdateDto {
    private String name;
    private String project;
    private String classroom;
    private Boolean presented;
    private List<String> members;

    public TeamUpdateDto(String name, String project, String classroom, Boolean presented, List<String> members) {
        this.name = name;
        this.project = project;
        this.classroom = classroom;
        this.presented = presented;
        this.members = members;
    }

    public TeamUpdateDto(Team team) {
        this.name = team.getName();
        this.project = team.getProject();
        this.classroom = team.getClassroom();
        this.presented = team.getPresented();
        this.members = team.getMembers();
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
