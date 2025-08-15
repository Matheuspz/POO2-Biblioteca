package univille.edu.br;

import univille.edu.br.Entidades.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        LivroDAO livroDAO = new LivroDAO();
        EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
        Scanner sc = new Scanner(System.in);
        boolean x = true;
        while (x) {
            System.out.print("Inisira um comando: ");
            switch (sc.nextLine()) {
                case "user list all":
                    usuarioDAO.listarTodos();
                    break;
                case "user list id":
                    System.out.print("ID: ");
                    usuarioDAO.listarPorId(sc.nextLong());
                    break;
                case "user insert":
                    Usuario usuario = new Usuario();
                    System.out.print("Nome: ");
                    usuario.setNome(sc.nextLine());
                    System.out.print("Email: ");
                    usuario.setEmail(sc.nextLine());
                    usuarioDAO.inserir(usuario);
                    break;
                case "user update":
                    Usuario usuario2 = new Usuario();
                    System.out.print("ID: ");
                    usuario2.setIdUsuario(1);
                    System.out.print("Nome: ");
                    usuario2.setNome(sc.nextLine());
                    System.out.print("Email: ");
                    usuario2.setEmail(sc.nextLine());
                    usuarioDAO.atualizar(usuario2);
                    break;
                case "user delete":
                    Usuario usuario3 = new Usuario();
                    System.out.print("ID: ");
                    usuario3.setIdUsuario(sc.nextLong());
                    usuarioDAO.excluir(usuario3);
                    break;

                case "livro list all":
                    livroDAO.listarTodos();
                    break;
                case "livro list id":
                    System.out.print("ID: ");
                    livroDAO.listarPorId(sc.nextLong());
                    break;
                case "livro insert":
                    Livro livro = new Livro();
                    System.out.print("Titulo: ");
                    livro.setTitulo(sc.nextLine());
                    livroDAO.inserir(livro);
                    break;
                case "livro update":
                    Livro livro2 = new Livro();
                    System.out.print("ID: ");
                    livro2.setIdLivro(sc.nextLong());
                    System.out.print("Titulo: ");
                    livro2.setTitulo(sc.nextLine());
                    livroDAO.atualizar(livro2);
                    break;
                case "livro delete":
                    Livro livro3 = new Livro();
                    System.out.print("ID: ");
                    livro3.setIdLivro(sc.nextLong());
                    livroDAO.excluir(livro3);

                case "emprestimo list all":
                    emprestimoDAO.listarTodos();
                    break;
                case "emprestimo list id":
                    System.out.print("ID: ");
                    emprestimoDAO.listarPorId(sc.nextLong());
                    break;
                case "emprestimo insert":
                    Emprestimo emprestimo2 = new Emprestimo();
                    System.out.print("ID: ");
                    emprestimo2.setIdEmprestimo(sc.nextLong());
                    System.out.print("ID Usuario: ");
                    emprestimo2.setIdUsuario(sc.nextLong());
                    System.out.print("ID Livro: ");
                    emprestimo2.setIdLivro(sc.nextLong());
                    emprestimo2.setDataEmprestimo(LocalDateTime.now());
                    emprestimo2.setDataDevolucao(LocalDateTime.now().plusDays(1));
                    emprestimoDAO.inserir(emprestimo2);
                    break;
                case "emprestimo update":
                    Emprestimo emprestimo3 = new Emprestimo();
                    System.out.print("ID: ");
                    emprestimo3.setIdEmprestimo(sc.nextLong());
                    System.out.print("Data Devolucao: ");
                    System.out.print(LocalDateTime.now());
                    emprestimo3.setDataEfetivaDevolucao(LocalDateTime.now());
                    emprestimoDAO.atualizar(emprestimo3);
                    break;
                case "emprestimo delete":
                    Emprestimo emprestimo4 = new Emprestimo();
                    System.out.print("ID: ");
                    emprestimo4.setIdEmprestimo(sc.nextLong());
                    emprestimoDAO.excluir(emprestimo4);
                    break;

                case "exit":
                    x = false;
            }
        }



    }
}
