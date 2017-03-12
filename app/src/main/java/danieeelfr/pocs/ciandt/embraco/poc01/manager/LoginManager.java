package danieeelfr.pocs.ciandt.embraco.poc01.manager;

import android.content.Context;

import danieeelfr.pocs.ciandt.embraco.poc01.business.login.LoginBusiness;
import danieeelfr.pocs.ciandt.embraco.poc01.repository.model.UsuarioModel;

/**
 * Created by Daniel on 10/03/2017.
 */

public class LoginManager {

    Context _context;

    public LoginManager(Context context)
    {
        _context = context;
    }

    public UsuarioModel Login(String usuario, String senha)
    {
        LoginBusiness loginBusiness = new LoginBusiness(_context);

        UsuarioModel usuarioModel = loginBusiness.ValidarLogin(usuario, senha);

        return  usuarioModel;
    }
}
