package univille.edu.br.Entidades;

import univille.edu.br.BaseDAO;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO extends BaseDAO implements DAO<Usuario> {

    @Override
    public Optional<Usuario> buscarPorId(long id) {

        Usuario usuario = null;
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));

                long idUsuario = rs.getLong(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                System.out.println("idUsuario: " + idUsuario + " | " + "Nome: " + nome + " | " + "Email: " + email);

                return Optional.of(usuario);
            }
            System.out.println("Nenhum usuario encontrado");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar o usuario "+ e.getMessage());
        };
        return Optional.empty();
    }

    @Override
    public List<Usuario> listarTodos() {
        return null;
    }

    @Override
    public void inserir(Usuario usuario) {

        String sql = "INSERT INTO Usuario (nome, email) VALUES (?, ?)";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ResultSet rs = ps.executeQuery();
            System.out.println("Usuário inserido com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao tentar inserir usuario "+ e.getMessage());
        }

    }

    @Override
    public void atualizar(Usuario usuario) {

        String sql = "UPDATE Usuario SET nome = ?, email = ? WHERE idUsuario = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ResultSet rs = ps.executeQuery();
            System.out.println("Usuario atualizado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar atualizar usuario "+ e.getMessage());
        }

    }

    @Override
    public void excluir(Usuario usuario) {

        String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, usuario.getIdUsuario());
            ResultSet rs = ps.executeQuery();
            System.out.println("Usuário Deletado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar excluir usuario "+ e.getMessage());
        }

    }
}
