package danieeelfr.pocs.ciandt.embraco.poc01.ui.atendimento;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import danieeelfr.pocs.ciandt.embraco.poc01.R;
import danieeelfr.pocs.ciandt.embraco.poc01.entity.AtendimentoModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class DetalheAtendimentoActivityFragment extends Fragment {

    public DetalheAtendimentoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhe_atendimento, container, false);

        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        AtendimentoModel atendimentoModel = (AtendimentoModel) extras.get("Atendimento");
        this.CarregarDadosAtendimento(atendimentoModel, view);

        return view;
    }

    private void CarregarDadosAtendimento(AtendimentoModel atendimentoModel, View view)
    {
        TextView txtCodOS = (TextView)view.findViewById(R.id.txtCodOS);
        TextView txtCliente = (TextView)view.findViewById(R.id.txtCliente);
        TextView txtEndereco = (TextView)view.findViewById(R.id.txtEndereco);
        TextView txtDescricaoProblema = (TextView)view.findViewById(R.id.txtDescricaoProblema);

        txtCodOS.setText(atendimentoModel.getCodOS());
        txtCliente.setText(atendimentoModel.getNomeCliente());
        txtEndereco.setText(atendimentoModel.getEndereco());
        txtDescricaoProblema.setText(atendimentoModel.getDescricaoProblema());

        Button btnIniciarAtendimento = (Button)view.findViewById(R.id.btnIniciarAtendimento);
        btnIniciarAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Iniciar atendimento", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
