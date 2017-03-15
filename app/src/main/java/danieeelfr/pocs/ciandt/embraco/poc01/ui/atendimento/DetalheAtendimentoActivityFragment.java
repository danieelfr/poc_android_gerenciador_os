package danieeelfr.pocs.ciandt.embraco.poc01.ui.atendimento;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

    private AlertDialog alerta;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalhe_atendimento, container, false);

        Intent intent = getActivity().getIntent();
        Bundle extras = intent.getExtras();
        AtendimentoModel atendimentoModel = (AtendimentoModel) extras.get("Atendimento");
        this.CarregarDadosAtendimento(atendimentoModel, view);
        this.IniciarBotoes(view);

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

    }

    private void IniciarBotoes(View view)
    {
        Button btnAbrirTelefone = (Button)view.findViewById(R.id.btnAbrirTelefone);
        ImageButton btnTelefone = (ImageButton)view.findViewById(R.id.btnTelefone);

        btnAbrirTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+"99778-3409");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        btnTelefone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("tel:"+"99778-3409");
                Intent intent = new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        Button btnIniciarAtendimento = (Button)view.findViewById(R.id.btnIniciarAtendimento);
        ImageButton btnAtendimento = (ImageButton)view.findViewById(R.id.btnAtendimento);

        btnIniciarAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmarAcaoIniciarAtendimento();
            }
        });

        btnAtendimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmarAcaoIniciarAtendimento();
            }
        });
    }

    private void ConfirmarAcaoIniciarAtendimento()
    {
        TextView txtCodOS = (TextView)getActivity().findViewById(R.id.txtCodOS);

        String codOS = txtCodOS.getText().toString();
        String mensagem = "Iniciar o atendimento da Ordem de Serviço: " + codOS + "?";
        String titulo ="Atendimento";

        ConfirmaAcao(codOS, mensagem, titulo);
    }

    private void ConfirmaAcao(String codOS, String mensagemConfirmacao, String tituloModal) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(tituloModal);
        builder.setMessage(mensagemConfirmacao);

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(getActivity(), "Iniciar atendimento  (gravar posição e hora)=" + arg1, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                return;
            }
        });
        alerta = builder.create();
        alerta.show();
    }
}
