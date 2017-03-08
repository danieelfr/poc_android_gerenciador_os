package danieeelfr.pocs.ciandt.embraco.poc01.ui.home;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import danieeelfr.pocs.ciandt.embraco.poc01.R;
import danieeelfr.pocs.ciandt.embraco.poc01.ui.atendimento.AtendimentoActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    public HomeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnOrdensServico = (Button)view.findViewById(R.id.btnOrdensServico);

        btnOrdensServico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), AtendimentoActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }
}
