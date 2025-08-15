package univille.edu.br.Entidades;

import univille.edu.br.BaseDAO;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmprestimoDAO extends BaseDAO implements DAO<Emprestimo> {

    @Override
    public List<Emprestimo> listarTodos() {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM Emprestimo";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Emprestimo emprestimo = new Emprestimo();
                setEmprestimo(emprestimo, rs);
                emprestimos.add(emprestimo);

            }
            for(Emprestimo emprestimo : emprestimos) {
                System.out.println(
                    "ID: " + emprestimo.getIdEmprestimo() + " | IdUsuario: " + emprestimo.getIdUsuario() +
                    " | IdLivro: " + emprestimo.getIdLivro()  + " | DataEmprestimo: " + emprestimo.getDataEmprestimo() +
                    " | DataPrevistaDevolução: " + emprestimo.getDataDevolucao() + " | DataEfetivaDevolucao: " + emprestimo.getDataEfetivaDevolucao()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Todos" + e.getMessage());
        }
        return emprestimos;
    }

    @Override
    public Optional<Emprestimo> listarPorId(long id) {
        Emprestimo emprestimo = new Emprestimo();
        String sql = "SELECT * FROM emprestimo WHERE idEmprestimo = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                setEmprestimo(emprestimo, rs);
                System.out.println(
                        "ID: " + emprestimo.getIdEmprestimo() + " | IdUsuario: " + emprestimo.getIdUsuario() +
                        " | IdLivro: " + emprestimo.getIdLivro()  + " | DataEmprestimo: " + emprestimo.getDataEmprestimo() +
                        " | DataPrevistaDevolução: " + emprestimo.getDataDevolucao() + " | DataEfetivaDevolucao: " + emprestimo.getDataEfetivaDevolucao()
                );

                return Optional.of(emprestimo);
            }
            System.out.println("Emprestimo não encontrado");
        } catch (SQLException e) {
            System.out.println("Erro ao listar Emprestimos " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void inserir(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo (idUsuario,idLivro,dataEmprestimo,dataPrevistaDevolucao) VALUES(?,?,?,?)";

        LocalDateTime dataEmprestimo = LocalDateTime.now();
        LocalDateTime dataPrevistaDevolucao = dataEmprestimo.plusDays(1);

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, emprestimo.getIdUsuario());
            ps.setLong(2, emprestimo.getIdLivro());
            ps.setTimestamp(3,Timestamp.valueOf(dataEmprestimo));
            ps.setTimestamp(4,Timestamp.valueOf(dataPrevistaDevolucao));
            ps.executeUpdate();
            System.out.println("Emprestimo adicionado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Emprestimo" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Emprestimo emprestimo) {
        String sql = "UPDATE emprestimo SET dataEfetivaDevolucao = ? WHERE idEmprestimo = ?";

        LocalDateTime dataEfetivaDevolucao = LocalDateTime.now();
        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, Timestamp.valueOf(dataEfetivaDevolucao));
            ps.setLong(2, emprestimo.getIdEmprestimo());
            ps.executeUpdate();
            System.out.println("Emprestimo atualizado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Emprestimo" + e.getMessage());
        }

    }

    @Override
    public void excluir(Emprestimo emprestimo) {
        String sql = "DELETE FROM emprestimo WHERE idEmprestimo = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, emprestimo.getIdEmprestimo());
            ps.executeUpdate();
            System.out.println("Emprestimo removido com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao deletar Emprestimo" + e.getMessage());
        }
    }

    public void listarEmprestimosIdUsuario(Emprestimo emprestimo) {
        List<Emprestimo> emprestimos = new ArrayList<>();
        String sql = "SELECT * FROM emprestimo WHERE idUsuario = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, emprestimo.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                while (rs.next()) {
                    Emprestimo emprestimo2 = new Emprestimo();
                    setEmprestimo(emprestimo2, rs);
                    emprestimos.add(emprestimo2);
                }
                for(Emprestimo emprestimo2 : emprestimos) {
                    System.out.println(
                            "ID: " + emprestimo2.getIdEmprestimo() + " | IdUsuario: " + emprestimo2.getIdUsuario() +
                                    " | IdLivro: " + emprestimo2.getIdLivro() + " | DataEmprestimo: " + emprestimo2.getDataEmprestimo() +
                                    " | DataPrevistaDevolução: " + emprestimo2.getDataDevolucao() + " | DataEfetivaDevolucao: " + emprestimo2.getDataEfetivaDevolucao()
                    );
                }
            }
            System.out.println("Usuario não possui emprestimos");
        } catch (SQLException e) {
            System.out.println("Erro ao listar Emprestimos " + e.getMessage());
        }
    }

    private void setEmprestimo(Emprestimo emprestimo, ResultSet rs) throws SQLException {
        emprestimo.setIdEmprestimo(rs.getLong("idEmprestimo"));
        emprestimo.setIdUsuario(rs.getLong("idEmprestimo"));
        emprestimo.setIdLivro(rs.getLong("idLivro"));
        emprestimo.setDataEmprestimo(rs.getTimestamp("dataEmprestimo").toLocalDateTime());
        emprestimo.setDataDevolucao(rs.getTimestamp("dataPrevistaDevolucao").toLocalDateTime());
        setDataEfetivaDevolucao(emprestimo,rs);
    }
    private void setDataEfetivaDevolucao(Emprestimo emprestimo, ResultSet rs) throws SQLException {
        Timestamp ts = rs.getTimestamp("dataEfetivaDevolucao");
        if(ts != null) {
            emprestimo.setDataEfetivaDevolucao(rs.getTimestamp("dataEfetivaDevolucao").toLocalDateTime());
        }
    }


}
