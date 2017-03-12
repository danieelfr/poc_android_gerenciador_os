package danieeelfr.pocs.ciandt.embraco.poc01.repository.service;

import java.util.List;

import danieeelfr.pocs.ciandt.embraco.poc01.repository.model.UsuarioModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Daniel on 10/03/2017.
 */

public interface LoginContract {

//    @GET("users/{user}/repos")
//    Call<List<UsuarioModel>> reposForUser(
//            @Path("user") String user
//    );

    @POST("login/{usuario}/{senha}")
    Call<UsuarioModel> getUsuario(
            @Path("usuario") String usuario,
            @Path("senha") String senha
    );
}
