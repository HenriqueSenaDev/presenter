package gov.edu.anm.presenter.model.entities;

public class Team {
    private Long id;
    private String name;
    private String project;
    private String classRoom;
    private Double average;
    private Boolean presented;
    private Integer avaliationsQuantity;

    public Team() {
    }

    public Team(Long id, String name, String project, String classRoom, Double average, Boolean presented, Integer avaliationsQuantity) {
        this.id = id;
        this.name = name;
        this.project = project;
        this.classRoom = classRoom;
        this.average = average;
        this.presented = presented;
        this.avaliationsQuantity = avaliationsQuantity;
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

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
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

    @Override
    public String toString() {
        return "Team{" + "id=" + id + ", name=" + name + ", project=" + project + ", classRoom=" + classRoom + ", average=" + average + ", presented=" + presented + ", avaliationsQuantity=" + avaliationsQuantity + '}';
    }
    
}
