package danieeelfr.pocs.ciandt.embraco.poc01.business.login;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import danieeelfr.pocs.ciandt.embraco.poc01.repository.model.UsuarioModel;
import danieeelfr.pocs.ciandt.embraco.poc01.repository.service.LoginContract;
import danieeelfr.pocs.ciandt.embraco.poc01.repository.service.LoginService;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 10/03/2017.
 */

public class LoginBusiness {

    private Context _context;
    private String _usuario;
    private String _senha;
    private UsuarioModel usuarioModel;

    public LoginBusiness(Context context)
    {
        _context = context;
    }

    public UsuarioModel ValidarLogin(String usuario, String senha) {
        _usuario = usuario;
        _senha = senha;

        try {
            usuarioModel = ConfiguraTask().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return usuarioModel;
    }

    private AsyncTask<Void, Void, UsuarioModel> ConfiguraTask() {

        AsyncTask<Void, Void, UsuarioModel> task = new AsyncTask<Void, Void, UsuarioModel>() {
            @Override
            protected UsuarioModel doInBackground(Void... params) {
                LoginService loginService = new LoginService(_context);

                usuarioModel = loginService.ValidarLogin(_usuario, _senha);
                return usuarioModel;
            }

            @Override
            protected void onPostExecute(UsuarioModel _usuarioModel) {
                usuarioModel = _usuarioModel;

                super.onPostExecute(usuarioModel);
            }

        };

        return  task;
    };
}
