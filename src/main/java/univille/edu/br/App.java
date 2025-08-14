package univille.edu.br;

import univille.edu.br.Entidades.Usuario;
import univille.edu.br.Entidades.UsuarioDAO;

import java.util.Optional;
import java.util.OptionalInt;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        Optional<Usuario> opt = dao.buscarPorId(3);
        System.out.println(opt);

//        Usuario usuario = new Usuario();
//        usuario.setNome("Thiago");
//        usuario.setEmail("Thiago@gmail.com");
//        dao.inserir(usuario);

    }
}
