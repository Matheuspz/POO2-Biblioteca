package univille.edu.br.Entidades;

import univille.edu.br.BaseDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAO extends BaseDAO implements DAO<Livro> {

    @Override
    public List<Livro> listarTodos() {
        List<Livro> livros = new ArrayList<>();
        String sql = "SELECT * FROM Livro";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Livro livro = new Livro();
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));
                livros.add(livro);
            }
            for(Livro livro : livros) {
                System.out.println(
                        "Livro ID: " + livro.getIdLivro() + "| Titulo: " + livro.getTitulo()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar Todos" + e.getMessage());
        }
        return livros;
    }

    @Override
    public Optional<Livro> listarPorId(long id) {
        Livro livro = new Livro();
        String sql = "SELECT * FROM Livro WHERE idLivro = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                livro.setIdLivro(rs.getInt("idLivro"));
                livro.setTitulo(rs.getString("titulo"));

                long idLivro = rs.getLong("idLivro");
                String titulo = rs.getString("titulo");
                System.out.println(
                        "Livro ID: " + idLivro + "| Titulo: " + titulo
                );

                return Optional.of(livro);
            }
            System.out.println("Livro não encontrado");
        } catch (SQLException e) {
            System.out.println("Erro ao listar livros " + e.getMessage());
        }
        return Optional.empty();
    }

    @Override
    public void inserir(Livro livro) {
        String sql = "INSERT INTO Livro (titulo) VALUES (?)";

        try(Connection con = con()){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.executeUpdate();
            System.out.println("Livro adicionado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir Livro" + e.getMessage());
        }

    }

    @Override
    public void atualizar(Livro livro) {
        String sql = "UPDATE Livro SET titulo = ? WHERE idLivro = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.setLong(2, livro.getIdLivro());
            ps.executeUpdate();
            System.out.println("Livro atualizado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar Livro" + e.getMessage());
        }

    }

    @Override
    public void excluir(Livro livro) {
        String sql = "DELETE FROM Livro WHERE idLivro = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, livro.getIdLivro());
            ps.executeUpdate();
            System.out.println("Livro deletado com sucesso");

        } catch (SQLException e) {
            System.out.println("Erro ao excluir Livro" + e.getMessage());
        }

    }
}
