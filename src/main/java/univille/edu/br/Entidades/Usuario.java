package univille.edu.br.Entidades;

import java.math.BigInteger;

public class Usuario {

    private BigInteger idUsuario;
    private String nome;
    private String email;

    public BigInteger getIdUsuario() { return idUsuario; }
    public void setIdUsuario(BigInteger idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Usuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }
}
