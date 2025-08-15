package univille.edu.br.Entidades;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Emprestimo {
    private long idEmprestimo;
    private long idUsuario;
    private long idLivro;
    private LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private LocalDateTime dataEfetivaDevolucao;

    public long getIdEmprestimo() { return idEmprestimo; }

    public void setIdEmprestimo(long idEmprestimo) { this.idEmprestimo = idEmprestimo; }

    public long getIdUsuario() { return idUsuario; }

    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public long getIdLivro() { return idLivro; }

    public void setIdLivro(long idLivro) { this.idLivro = idLivro; }

    public LocalDateTime getDataEmprestimo() { return dataEmprestimo; }

    public void setDataEmprestimo(LocalDateTime dataEmprestimo) { this.dataEmprestimo = dataEmprestimo; }

    public LocalDateTime getDataDevolucao() { return dataDevolucao; }

    public void setDataDevolucao(LocalDateTime dataDevolucao) { this.dataDevolucao = dataDevolucao; }

    public LocalDateTime getDataEfetivaDevolucao() { return dataEfetivaDevolucao; }

    public void setDataEfetivaDevolucao(LocalDateTime dataEfetivaDevolucao) {this.dataEfetivaDevolucao = dataEfetivaDevolucao; }
}
