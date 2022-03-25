package gov.edu.anm.presenter.dao;

import gov.edu.anm.presenter.jdbc.ConnectionFactory;
import gov.edu.anm.presenter.model.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class EquipeDAO {

    private Connection con;

    public EquipeDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void salvarEquipe(Equipe equipe) {
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
            
            JOptionPane.showMessageDialog(null, "Equipe cadastrada.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro:\n" + e);
        }
    }

}
