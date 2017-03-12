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

        AsyncTask<Void, Void, UsuarioModel> task = new AsyncTask<Void, Void, UsuarioModel>() {
            @Override
            protected UsuarioModel doInBackground(Void... params) {
                OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

                final Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("https://pocembraco.appspot.com/_ah/api/pocEmbracoApi/v1/")
                        .addConverterFactory(GsonConverterFactory.create());

                Retrofit retrofit = builder.client(httpClient.build()).build();
                LoginContract client = retrofit.create(LoginContract.class);
                Call<UsuarioModel> call = client.getUsuario(_usuario, _senha);

                try {
                    usuarioModel = call.execute().body();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // return userInfo.body();
                return usuarioModel;
            }

            @Override
            protected void onPostExecute(UsuarioModel _usuarioModel) {
                usuarioModel = _usuarioModel;

                super.onPostExecute(usuarioModel);
            }
        };

        //task.execute();
        try {
            usuarioModel = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return usuarioModel;
    }
}
