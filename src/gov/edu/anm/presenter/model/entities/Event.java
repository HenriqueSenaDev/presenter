package gov.edu.anm.presenter.model.entities;

public class Event {
    private Long id;
    private String name;
    private Integer code;
    private Integer jurorCode;
    private String description;

    public Event() {
        
    }
    
    public Event(Long id, String name, Integer code, Integer jurorCode, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.jurorCode = jurorCode;
        this.description = description;
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getJurorCode() {
        return jurorCode;
    }

    public void setJurorCode(Integer jurorCode) {
        this.jurorCode = jurorCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Event{" + "id=" + id + ", name=" + name + ", code=" + code + ", jurorCode=" + jurorCode + ", description=" + description + '}';
    }
    
}
