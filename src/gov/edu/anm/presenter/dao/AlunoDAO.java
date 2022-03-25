package gov.edu.anm.presenter.dao;

import gov.edu.anm.presenter.jdbc.ConnectionFactory;
import gov.edu.anm.presenter.model.Aluno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AlunoDAO {

    private Connection con;

    public AlunoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public void salvarAluno(Aluno aluno, String nomeEquipe) {
        int equipeId = 0;
        try {
            try {
                String sql = "select * from tb_equipes where nome = ?";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, nomeEquipe);

                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    equipeId = rs.getInt("id");
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro na busca de equipe:\n" + e);
            }

            try {
                String sql = "insert into tb_alunos (nome, id_equipe) values (?, ?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setString(1, aluno.getNome());
                stmt.setInt(2, equipeId);

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro no cadastro dos alunos:\n" + e);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no cadastro:\n" + e);
        }

    }
}
