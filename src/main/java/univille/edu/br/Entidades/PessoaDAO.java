//package univille.edu.br.Entidades;
//
//import univille.edu.br.BaseDAO;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//// DAO -> Data Access Object
//// Mapeia os objetos para sql
//// sql para objeto
//public class PessoaDAO extends BaseDAO {
//
//    public void deletarPeloId(long id){
//        String sql = "delete from pessoa where id_pessoa = ? ";
//        // try-with-resources
//        // fecha automaticamente o recurso aberto.
//        try(Connection con = con();
//            PreparedStatement pre = con.prepareStatement(sql)){
//            pre.setLong(1,id);
//            pre.execute();
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    // TODO
//    public void inserir(Pessoa pessoa){
//
//    }
//
//    // TODO
//    public void atualizar(Pessoa pessoa){
//
//    }
//
//    // TODO
//    public List<Pessoa> obterTodos(){
//        return null;
//    }
//
//    // Optional evita ponto nulo
//    public Optional<Pessoa> obterPeloId(long id){
//        String sql = "select id_pessoa, nome, cpf from pessoa where id_pessoa = ? ";
//        Pessoa pessoa = null;
//        // try-with-resources
//        // fecha automaticamente o recurso aberto.
//        try(var con = con();
//            var pre = con.prepareStatement(sql)){
//            pre.setLong(1,id);
//            var rs = pre.executeQuery();
//            if(rs.next()){
//                pessoa = new Pessoa();
//                pessoa.setId(rs.getLong("id_pessoa"));
//                pessoa.setNome("nome");
//                pessoa.setCpf("cpf");
//                return Optional.of(pessoa);
//            }
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//        return Optional.empty();
//    }
//
//
//}
