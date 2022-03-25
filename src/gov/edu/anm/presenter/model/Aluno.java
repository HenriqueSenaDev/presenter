
package gov.edu.anm.presenter.model;

public class Aluno {
    private Integer id;
    private String nome;
    private Equipe equipe;

    public Aluno(Integer id, String nome, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.equipe = equipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }
}
