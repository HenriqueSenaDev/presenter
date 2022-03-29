package gov.edu.anm.presenter.dao;

import gov.edu.anm.presenter.jdbc.ConnectionFactory;
import gov.edu.anm.presenter.model.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EquipeDAO {

    private Connection con;

    public EquipeDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void salvarEquipe(Equipe equipe) throws SQLException{
        try {
            String sql = "insert into tb_equipes (nome, projeto, turma, pontuacao, apresentou) "
                    + "values (?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getProjeto());
            stmt.setString(3, equipe.getTurma());
            stmt.setDouble(4, equipe.getPontuacao());
            stmt.setBoolean(5, equipe.getApresentou());
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new SQLException("Erro no cadastro da equipe:\n" + e);
        }
    }

}
