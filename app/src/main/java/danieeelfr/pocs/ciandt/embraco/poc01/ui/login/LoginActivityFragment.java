package danieeelfr.pocs.ciandt.embraco.poc01.ui.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.BoolRes;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import danieeelfr.pocs.ciandt.embraco.poc01.R;
import danieeelfr.pocs.ciandt.embraco.poc01.manager.LoginManager;
import danieeelfr.pocs.ciandt.embraco.poc01.repository.model.UsuarioModel;
import danieeelfr.pocs.ciandt.embraco.poc01.ui.home.HomeActivity;

import static danieeelfr.pocs.ciandt.embraco.poc01.R.id.btnEntrar;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {

    ProgressDialog progressDialog;
    Boolean loginValido;

    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_login, container, false);
        Button btnEntrar = (Button)view.findViewById(R.id.btnEntrar);

        loginValido = false;

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = ProgressDialog.show(getActivity(), "Login",  "Validando dados...", true);
                progressDialog.setCancelable(true);

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Login();

                            if (loginValido)
                            {
                                Intent intent = new Intent(getActivity(), HomeActivity.class);
                                startActivity(intent);
                            }

                        } catch (Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }).start();
            }
        });

        return view;
    }

    private void Login()
    {
        EditText txtUsuario = (EditText)getActivity().findViewById(R.id.txtUsuario);
        EditText txtSenha = (EditText)getActivity().findViewById(R.id.txtSenha);

        LoginManager loginManager = new LoginManager(getActivity());

        UsuarioModel usuarioModel = loginManager.Login(txtUsuario.getText().toString(), txtSenha.getText().toString());

        if (usuarioModel != null)
        {
            loginValido = true;
        }
        else
        {
            loginValido = false;
        }

        progressDialog.dismiss();
    }
}