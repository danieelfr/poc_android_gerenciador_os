package danieeelfr.pocs.ciandt.embraco.poc01.service.gae;

/**
 * The object model for the data we are sending through endpoints
 */
public class sUsuario {

    public sUsuario(){};

    private String nome;
    private String email;

    public String getNome() {
        return nome;
    }
    public String getEmail() {
        return email;
    }


    public void setNome(String _nome) { nome = _nome; }
    public void setEmail(String _email) { email = _email; }



//    public sUsuario getUsuarioFake()
//    {
//
//        this.setNome("sUsuario fake");
//        this.setEmail("email@fake.com.br");
//
//        return this;
//    }
}