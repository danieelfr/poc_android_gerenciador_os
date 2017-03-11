package danieeelfr.pocs.ciandt.embraco.poc01.service.gae;

/**
 * The object model for the data we are sending through endpoints
 */
public class Usuario {

    private String nome;
    private String email;

    public String getNome() {
        return this.nome;
    }
    public String getEmail() {
        return this.email;
    }

    public void setNome(String nome) { this.nome = nome; }
    public void setEmail(String email) { this.email = email; }

    public Usuario getUsuarioFake()
    {
        this.setNome("Usuario fake");
        this.setEmail("email@fake.com.br");

        return this;
    }
}