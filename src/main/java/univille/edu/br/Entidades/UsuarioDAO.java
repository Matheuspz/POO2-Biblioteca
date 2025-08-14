package univille.edu.br.Entidades;

import univille.edu.br.BaseDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsuarioDAO extends BaseDAO implements DAO<Usuario> {

    @Override
    public List<Usuario> listarTodos() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuarios.add(usuario);
            }

            for (Usuario usuario : usuarios) {
                System.out.println(
                        "ID: " + usuario.getIdUsuario() + " | Nome: " + usuario.getNome() + " | Email: " + usuario.getEmail()
                );
            }

        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar todos os usuarios"+ e.getMessage());
        }
        return usuarios;
    }

    @Override
    public Optional<Usuario> listarPorId(long id) {

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
                System.out.println("ID: " + idUsuario + " | " + "Nome: " + nome + " | " + "Email: " + email);

                return Optional.of(usuario);
            }
            System.out.println("Nenhum usuario encontrado");
        } catch (SQLException e) {
            System.out.println("Erro ao tentar buscar o usuario "+ e.getMessage());
        };
        return Optional.empty();
    }

    @Override
    public void inserir(Usuario usuario) {

        String sql = "INSERT INTO Usuario (nome, email) VALUES (?, ?)";

        try(Connection con = con()) {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,usuario.getNome());
            ps.setString(2,usuario.getEmail());
            ps.executeUpdate();
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
            ps.setLong(3,usuario.getIdUsuario());
            ps.executeUpdate();
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
            ps.executeUpdate();
            System.out.println("Usuário Deletado com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao tentar excluir usuario "+ e.getMessage());
        }
    }
}
