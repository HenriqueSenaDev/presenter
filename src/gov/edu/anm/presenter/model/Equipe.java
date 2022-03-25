package gov.edu.anm.presenter.model;

import java.util.ArrayList;
import java.util.List;

public class Equipe {
    private Integer id;
    private String nome;
    private String projeto;
    private String turma;
    private Double pontuacao;
    private Boolean apresentou;
    private List<Aluno> alunos = new ArrayList<>();

    public Equipe(String nome, String projeto, String turma) {
        this.nome = nome;
        this.projeto = projeto;
        this.turma = turma;
        this.pontuacao = 0.0;
        this.apresentou = false;
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

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public Double getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Double pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Boolean getApresentou() {
        return apresentou;
    }

    public void setApresentou(Boolean apresentou) {
        this.apresentou = apresentou;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }    
}
