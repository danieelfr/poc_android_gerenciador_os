package danieeelfr.pocs.ciandt.embraco.poc01.ui.atendimento;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import danieeelfr.pocs.ciandt.embraco.poc01.R;
import danieeelfr.pocs.ciandt.embraco.poc01.entity.AtendimentoModel;

/**
 * Created by danielfr on 06/03/2017.
 */

public class AtendimentoAdapter extends BaseAdapter {

    private List<AtendimentoModel> atendimentos;
    private Activity activity;

    public AtendimentoAdapter(Activity activity, List<AtendimentoModel> atendimentos)
    {
        this.activity = activity;
        this.atendimentos = atendimentos;
    }

    @Override
    public int getCount() {
        return atendimentos.size();
    }

    @Override
    public Object getItem(int position) {
        return atendimentos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return atendimentos.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = this.activity.getLayoutInflater().inflate(R.layout.item_lista_atendimentos, null);

        AtendimentoModel atendimento = atendimentos.get(position);

        TextView tvDataPrevista = (TextView) view.findViewById(R.id.tvDataPrevista);
        tvDataPrevista.setText(atendimento.getDataPrevista().toString());

        TextView tvHoraInicioPrevisto = (TextView) view.findViewById(R.id.tvHoraInicioPrevisto);
        tvHoraInicioPrevisto.setText(atendimento.getHoraInicioPrevisto().toString());

        TextView tvCodOS = (TextView) view.findViewById(R.id.tvCodOS);
        tvCodOS.setText(atendimento.getCodOS().toString());

        TextView tvCliente = (TextView) view.findViewById(R.id.tvCliente);
        tvCliente.setText(atendimento.getNomeCliente().toString());

        TextView tvEndereço = (TextView) view.findViewById(R.id.tvEndereço);
        tvEndereço.setText(atendimento.getEndereco().toString());

        TextView tvEquipamento = (TextView) view.findViewById(R.id.tvEquipamento);
        tvEquipamento.setText(atendimento.getEquipamento().toString());

        // Button btn

        return view;
    }
}
