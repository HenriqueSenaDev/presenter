package gov.edu.anm.presenter.domain.team;

import java.util.List;

public class TeamCreateDto {
    private String name;
    private String project;
    private String classroom;
    private List<String> members;

    public TeamCreateDto(String name, String project, String classroom, List<String> members) {
        this.name = name;
        this.project = project;
        this.classroom = classroom;
        this.members = members;
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

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }
}
