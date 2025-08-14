package univille.edu.br.Entidades;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {

    List<T> listarTodos();

    Optional<T> buscarPorId(long id);

    void inserir(T t);

    void atualizar(T t);

    void excluir(T t);

}
