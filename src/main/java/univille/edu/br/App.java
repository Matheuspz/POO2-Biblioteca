package univille.edu.br;

import univille.edu.br.Entidades.Usuario;
import univille.edu.br.Entidades.UsuarioDAO;

import java.util.List;
import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        List<Usuario> list = dao.listarTodos();
//        for (Usuario usuario : list) {
//            System.out.println(
//                "ID: " + usuario.getIdUsuario() + " | Nome: " + usuario.getNome() + " | Email: " + usuario.getEmail()
//            );
//        }
        System.out.println(" ");

        Optional<Usuario> opt = dao.listarPorId(4);
//        opt.ifPresent(usuario ->  {
//            System.out.print("ID: " + usuario.getIdUsuario() + " | ");
//            System.out.print("Nome: " + usuario.getNome() + " | ");
//            System.out.println("Email: " + usuario.getEmail());
//        });
//        System.out.println(opt);

        System.out.println(" ");

// ------------------- INSERT --------------------------
//        Usuario usuario = new Usuario();
//        usuario.setNome("Thiago");
//        usuario.setEmail("Thiago@gmail.com");
//        dao.inserir(usuario);

    }
}
