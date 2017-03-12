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
    private Response<UsuarioModel> userInfo;

    public LoginService(Context context)
    {
        _context = context;
    }

    public UsuarioModel ValidarLogin(String usuario, String senha)
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        final Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://pocembraco.appspot.com/_ah/api/pocEmbracoApi/v1/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.client(httpClient.build()).build();
        LoginContract client = retrofit.create(LoginContract.class);
        Call<UsuarioModel> call = client.getUsuario(usuario, senha);

        try {
            userInfo = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInfo.body();
//        call.enqueue(new Callback<UsuarioModel>() {
//            @Override
//            public void onResponse(Call<UsuarioModel> call, Response<UsuarioModel> response) {
//                userInfo = response.body();
//            }
//
//            @Override
//            public void onFailure(Call<UsuarioModel> call, Throwable t) {
//                Toast.makeText(_context, "Ops: " + t.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//        return userInfo;
    }
}
