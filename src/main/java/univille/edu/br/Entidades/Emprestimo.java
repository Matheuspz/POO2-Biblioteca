package univille.edu.br.Entidades;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {
    private BigInteger idEmprestimo;
    private Usuario idUsuario;
    private Livro idLivro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private LocalDateTime dataEfetivaDevolucao;

    public BigInteger getIdEmprestimo() { return idEmprestimo; }

    public void setIdEmprestimo(BigInteger idEmprestimo) { this.idEmprestimo = idEmprestimo; }

    public Usuario getIdUsuario() { return idUsuario; }

    public void setIdUsuario(Usuario idUsuario) { this.idUsuario = idUsuario; }

    public Livro getIdLivro() { return idLivro; }

    public void setIdLivro(Livro idLivro) { this.idLivro = idLivro; }

    public LocalDateTime getDataEmprestimo() { return dataEmprestimo; }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public LocalDateTime getDataDevolucao() { return dataDevolucao; }

    public void setDataDevolucao(LocalDateTime dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public LocalDateTime getDataEfetivaDevolucao() { return dataEfetivaDevolucao; }

    public void setDataEfetivaDevolucao(LocalDateTime dataEfetivaDevolucao) {this.dataEfetivaDevolucao = dataEfetivaDevolucao; }
}
