package danieeelfr.pocs.ciandt.embraco.poc01.ui.atendimento;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.ListViewAutoScrollHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.util.List;

import danieeelfr.pocs.ciandt.embraco.poc01.R;
import danieeelfr.pocs.ciandt.embraco.poc01.entity.AtendimentoModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class AtendimentoActivityFragment extends Fragment {

    public AtendimentoActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_atendimento, container, false);

        try {
            final List<AtendimentoModel> atendimentos = new AtendimentoModel().getListaAtendimentosFake();

            AtendimentoAdapter atendimentoAdapter = new AtendimentoAdapter(getActivity(), atendimentos);
            ListView lvAtendimentos = (ListView)view.findViewById(R.id.lvAtendimentos);
            lvAtendimentos.setAdapter(atendimentoAdapter);

            lvAtendimentos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getActivity(), DetalheAtendimentoActivity.class);
                    intent.putExtra("Atendimento", atendimentos.get(position));
                    startActivity(intent);
                    // Toast.makeText(getActivity(), "Position: " + position, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (ParseException e) {
            Log.e(getActivity().getLocalClassName(), e.getMessage(), e);
        }

        return view;
    }
}
