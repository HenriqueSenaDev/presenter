
package gov.edu.anm.presenter.model.entities;

public class Student {
    private Long id;
    private Long teamId;
    private String nome;

    public Student() {
    }

    public Student(Long id, Long teamId, String nome) {
        this.id = id;
        this.teamId = teamId;
        this.nome = nome;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", teamId=" + teamId + ", nome=" + nome + '}';
    }
    
}
