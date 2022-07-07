
package gov.edu.anm.presenter.model.entities;

public class Aluno {
    private Integer id;
    private String nome;
    private Equipe equipe;

    public Aluno(String nome, Equipe equipe) {
        this.nome = nome;
        this.equipe = equipe;
    }
    
    public Aluno(String nome){
        this.nome = nome;
    }
    
    public Integer getId(){
        return id;
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
