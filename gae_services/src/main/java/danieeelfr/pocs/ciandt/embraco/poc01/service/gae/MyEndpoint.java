/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package danieeelfr.pocs.ciandt.embraco.poc01.service.gae;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

import static com.google.appengine.api.memcache.MemcacheServicePb.MemcacheService_3.Method.Get;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "pocEmbracoApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "gae.service.poc01.embraco.ciandt.pocs.danieeelfr",
                ownerName = "gae.service.poc01.embraco.ciandt.pocs.danieeelfr",
                packagePath = ""
        )
)
public class MyEndpoint {

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "sayHi")
    public sUsuario sayHi(@Named("name") String name) {
        sUsuario response = new sUsuario();
        response.setNome("Hi, " + name);

        return response;
    }

    @ApiMethod(name = "login")
    public sUsuario login(@Named("usuario") String usuario, @Named("senha") String senha) {

        if (usuario.equals("teste")) {
            sUsuario response = new sUsuario();

            response.setNome(usuario);
            response.setEmail(usuario + "@email.com");

            return response;
        }

        return null;
    }
}
