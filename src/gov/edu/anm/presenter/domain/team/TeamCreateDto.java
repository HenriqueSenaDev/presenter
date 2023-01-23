package gov.edu.anm.presenter.domain.team;

public class TeamCreateDto {
    private Long id;
    private String name;
    private String project;
    private String classroom;

    public TeamCreateDto(Long id, String name, String project, String classroom) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.classroom = classroom;
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
}
