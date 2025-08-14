package univille.edu.br.Entidades;

import java.math.BigInteger;

public class Usuario {

    private long idUsuario;
    private String nome;
    private String email;

    public Usuario() { }

    public long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(long idUsuario) { this.idUsuario = idUsuario; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
