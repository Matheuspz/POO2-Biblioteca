package univille.edu.br.Entidades;

import java.math.BigInteger;

public class Livro {
    private BigInteger idLivro;
    private String titulo;

    public BigInteger getIdLivro() { return idLivro; }

    public void setIdLivro(BigInteger idLivro) { this.idLivro = idLivro; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Livro(BigInteger idLivro) { this.idLivro = idLivro; }
}
