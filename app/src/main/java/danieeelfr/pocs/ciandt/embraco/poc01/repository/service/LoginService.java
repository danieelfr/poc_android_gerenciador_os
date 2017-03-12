package danieeelfr.pocs.ciandt.embraco.poc01.repository.service;

import android.content.Context;
import android.widget.Toast;


import java.io.IOException;

import danieeelfr.pocs.ciandt.embraco.poc01.repository.model.UsuarioModel;
import danieeelfr.pocs.ciandt.embraco.poc01.ui.login.LoginActivity;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Daniel on 10/03/2017.
 */

public class LoginService {

    private Context _context;
    private UsuarioModel _usuarioModel;
    private String _usuario;
    private String _senha;

    public LoginService(Context context)
    {
        _context = context;
    }

    public UsuarioModel ValidarLogin(String usuario, String senha)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        _usuario = usuario;
        _senha = senha;

        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://pocembraco.appspot.com/_ah/api/pocEmbracoApi/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        LoginContract client = retrofit.create(LoginContract.class);
        Call<UsuarioModel> call = client.getUsuario(_usuario, _senha);

        try {
            _usuarioModel = call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return _usuarioModel;
    }
}
