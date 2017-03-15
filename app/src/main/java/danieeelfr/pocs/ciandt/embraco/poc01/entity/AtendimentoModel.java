package danieeelfr.pocs.ciandt.embraco.poc01.entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by danielfr on 06/03/2017.
 */

public class AtendimentoModel implements Serializable {

    private int Id;
    private String CodOS;
    private String NomeCliente;
    private String Endereco;
    private String Equipamento;
    private String DescricaoProblema;
    private String HoraInicioPrevisto;
    private String DataPrevista;

    public AtendimentoModel(int id, String codOS, String nomeCliente, String endereco, String equipamento, String descricaoProblema, String dataPrevista, String horaInicioPrevisto)
    {
        super();
        this.Id = id;
        this.CodOS = codOS;
        this.NomeCliente = nomeCliente;
        this.Endereco = endereco;
        this.Equipamento = equipamento;
        this.DescricaoProblema = descricaoProblema;
        this.HoraInicioPrevisto = horaInicioPrevisto;
        this.DataPrevista = dataPrevista;
    }

    public AtendimentoModel()
    {

    }

    public int getId() {
        return this.Id;
    }

    public String getCodOS()
    {
        return this.CodOS;
    }

    public String getNomeCliente()
    {
        return this.NomeCliente;
    }

    public String getEndereco()
    {
        return this.Endereco;
    }

    public String getEquipamento()
    {
        return this.Equipamento;
    }

    public String getDescricaoProblema()
    {
        return this.DescricaoProblema;
    }

    public String getHoraInicioPrevisto()
    {
        return this.HoraInicioPrevisto;
    }

    public String getDataPrevista()
    {
        return this.DataPrevista;
    }

    public List<AtendimentoModel> getListaAtendimentosFake() throws ParseException {

        SimpleDateFormat dataFull = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
        Date date1 = dataFull.parse("20-03-2017 09:00");
        Date date2 = dataFull.parse("20-03-2017 12:00");
        Date date3 = dataFull.parse("20-03-2017 15:00");
        Date date4 = dataFull.parse("21-03-2017 09:00");
        Date date5 = dataFull.parse("21-03-2017 10:00");

        List<AtendimentoModel> lista = new ArrayList<AtendimentoModel>();

        AtendimentoModel atendimento1 = new AtendimentoModel(1, "OS A0001", "Carlos da Silva", "Avenida dos Andradas, 3000, Santa Efigência, Belo Horizonte - MG", "Geladeira", "Explicação do problema", data.format(date1), hora.format(date1));
        AtendimentoModel atendimento2 = new AtendimentoModel(2, "OS B0002", "Silvana Oliveira Santos", "Avenida dos Andradas, 3000, Santa Efigência, Belo Horizonte - MG", "Geladeira", "Explicação do problema", data.format(date2), hora.format(date2));
        AtendimentoModel atendimento3 = new AtendimentoModel(3, "OS A0003", "Carlos Caramujo", "Avenida dos Andradas, 3000, Santa Efigência, Belo Horizonte - MG", "Geladeira", "Explicação do problema", data.format(date3), hora.format(date3));
        AtendimentoModel atendimento4 = new AtendimentoModel(4, "OS B0004", "João Profeta Jr", "Avenida dos Andradas, 3000, Santa Efigência, Belo Horizonte - MG", "Geladeira", "Explicação do problema", data.format(date4), hora.format(date4));
        AtendimentoModel atendimento5 = new AtendimentoModel(5, "OS A005", "Guilherme Henrique Neto", "Avenida dos Andradas, 3000, Santa Efigência, Belo Horizonte - MG", "Descrição Equipamento", "Descricao Problema 5", data.format(date5), hora.format(date5));

        lista.add(atendimento1);
        lista.add(atendimento2);
        lista.add(atendimento3);
        lista.add(atendimento4);
        lista.add(atendimento5);
        lista.add(atendimento1);
        lista.add(atendimento1);
        lista.add(atendimento2);
        lista.add(atendimento3);
        lista.add(atendimento4);
        lista.add(atendimento5);
        lista.add(atendimento1);
        lista.add(atendimento2);
        lista.add(atendimento3);
        lista.add(atendimento4);
        lista.add(atendimento5);
        lista.add(atendimento2);
        lista.add(atendimento3);
        lista.add(atendimento4);
        lista.add(atendimento5);

        return lista;
    }
}