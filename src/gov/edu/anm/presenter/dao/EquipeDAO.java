package gov.edu.anm.presenter.dao;

import gov.edu.anm.presenter.jdbc.ConnectionFactory;
import gov.edu.anm.presenter.model.Equipe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAO {

    private Connection con;

    public EquipeDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    public Equipe getEquipeWithId(Equipe equipe) throws SQLException {
        try {
            String sql = "select * from tb_equipes where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, equipe.getNome());

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                equipe.setId(rs.getInt("id"));
            }
            stmt.execute();
            stmt.close();

            return equipe;
        } catch (SQLException e) {
            throw new SQLException("Erro na busca de equipe:\n" + e);
        }
    }

    public void salvarEquipe(Equipe equipe) throws SQLException {
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

    public List<Equipe> listarEquipes() throws SQLException {
        try {
            List<Equipe> equipes = new ArrayList<>();
            String sql = "select * from tb_equipes";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Equipe equipe = new Equipe();

                equipe.setId(rs.getInt("id"));
                equipe.setNome(rs.getString("nome"));
                equipe.setProjeto(rs.getString("projeto"));
                equipe.setTurma(rs.getString("turma"));
                equipe.setPontuacao(rs.getDouble("pontuacao"));
                equipe.setApresentou(rs.getBoolean("apresentou"));

                equipes.add(equipe);
            }

            stmt.execute();
            stmt.close();
            return equipes;
        } catch (SQLException e) {
            throw new SQLException("Erro na busca de equipes:\n" + e);
        }
    }

    public void excluirEquipe(String name) throws SQLException {
        try {
            String sqlDisableKey = "set FOREIGN_KEY_CHECKS=0";
            PreparedStatement stmtDisableKey = con.prepareStatement(sqlDisableKey);
            stmtDisableKey.execute();
            stmtDisableKey.close();

            String sqlDelete = "delete from tb_equipes where nome = ?";
            PreparedStatement stmtDelete = con.prepareStatement(sqlDelete);
            stmtDelete.setString(1, name);
            stmtDelete.execute();
            stmtDelete.close();

            String sqlEnableKey = "set FOREIGN_KEY_CHECKS=1";
            PreparedStatement stmtEnableKey = con.prepareStatement(sqlEnableKey);
            stmtEnableKey.execute();
            stmtEnableKey.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao excluir a equipe:\n" + e);
        }
    }

    public void editarEquipe(Equipe equipe) throws SQLException {
        try {
            String sql = "update tb_equipes set nome=?, projeto=?, turma=? where "
                    + "nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, equipe.getNome());
            stmt.setString(2, equipe.getProjeto());
            stmt.setString(3, equipe.getTurma());
            stmt.setString(4, equipe.getNome());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao editar a equipe:\n" + e);
        }
    }

}
