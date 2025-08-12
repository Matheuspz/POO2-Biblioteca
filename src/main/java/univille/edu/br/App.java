package univille.edu.br;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        PessoaDAO dao = new PessoaDAO();
        var opt = dao.obterPeloId(1);
        System.out.println(opt);
        opt = dao.obterPeloId(1000);
        if(opt.isEmpty()){
            System.out.println("Nao encontrou a pessoa.");
        }
    }
}
