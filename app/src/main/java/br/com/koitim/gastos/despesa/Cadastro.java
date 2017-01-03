package br.com.koitim.gastos.despesa;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import br.com.koitim.gastos.R;
import br.com.koitim.gastos.dao.CategoriaDAO;
import br.com.koitim.gastos.dao.CredorDAO;
import br.com.koitim.gastos.dao.FavorecidoDAO;
import br.com.koitim.gastos.dao.FonteDAO;
import br.com.koitim.gastos.interfaces.OnDespesaInteractionListener;
import br.com.koitim.gastos.model.Categoria;
import br.com.koitim.gastos.model.Credor;
import br.com.koitim.gastos.model.Favorecido;
import br.com.koitim.gastos.model.Fonte;
import br.com.koitim.gastos.util.DateDialog;


public class Cadastro extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

  private EditText etData;
  private EditText etValor;
  private Spinner spFonte;
  private Spinner spCategoria;
  private Spinner spCredor;
  private Spinner spFavorecido;
  private Button btSalvar;

  private List<Fonte> fontes;
  private List<Categoria> categorias;
  private List<Credor> credores;
  private List<Favorecido> favorecidos;

  private Fonte fonteSelecionada;
  private Categoria categoriaSelecionada;
  private Credor credorSelecionado;
  private Favorecido favorecidoSelecionado;

  private OnDespesaInteractionListener mListener;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    //TODO: Recuperar o saldo da conta

    FonteDAO fonteDAO = new FonteDAO(getActivity());
    fontes = fonteDAO.findAll();
    fontes.add(0, new Fonte(""));

    CategoriaDAO categoriaDAO = new CategoriaDAO(getActivity());
    categorias = categoriaDAO.findAll();
    categorias.add(0, new Categoria(""));

    CredorDAO credorDAO = new CredorDAO(getActivity());
    credores = credorDAO.findAll();
    credores.add(0, new Credor(""));

    FavorecidoDAO favorecidoDAO = new FavorecidoDAO(getActivity());
    favorecidos = favorecidoDAO.findAll();
    favorecidos.add(0, new Favorecido(""));
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view =inflater.inflate(R.layout.despesa_cadastro_layout, container, false);

    etData = (EditText) view.findViewById(R.id.despesa_et_data);
    etData.setOnClickListener(this);

    etValor = (EditText) view.findViewById(R.id.despesa_et_valor);

    spFonte = (Spinner) view.findViewById(R.id.despesa_sp_fonte);
    ArrayAdapter<Fonte> adapterFonte = new ArrayAdapter(
        getActivity(), android.R.layout.simple_spinner_dropdown_item, fontes
    );
    adapterFonte.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spFonte.setAdapter(adapterFonte);
    spFonte.setOnItemSelectedListener(this);

    spCategoria = (Spinner) view.findViewById(R.id.despesa_sp_categoria);
    ArrayAdapter<Categoria> adapterCategoria = new ArrayAdapter(
        getActivity(), android.R.layout.simple_spinner_dropdown_item, categorias
    );
    adapterCategoria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spCategoria.setAdapter(adapterCategoria);
    spCategoria.setOnItemSelectedListener(this);

    spCredor = (Spinner) view.findViewById(R.id.despesa_sp_credor);
    ArrayAdapter<Credor> adapterCredor = new ArrayAdapter(
        getActivity(), android.R.layout.simple_spinner_dropdown_item, credores
    );
    adapterCredor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spCredor.setAdapter(adapterCredor);
    spCredor.setOnItemSelectedListener(this);

    spFavorecido = (Spinner) view.findViewById(R.id.despesa_sp_favorecido);
    ArrayAdapter<Favorecido> adapterFavorecido = new ArrayAdapter(
        getActivity(), android.R.layout.simple_spinner_dropdown_item, favorecidos
    );
    adapterFavorecido.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spFavorecido.setAdapter(adapterFavorecido);
    spFavorecido.setOnItemSelectedListener(this);

    btSalvar = (Button) view.findViewById(R.id.despesa_bt_salvar);
    btSalvar.setOnClickListener(this);

    return view;
  }

  @Override
  public void onClick(View view) {
    switch (view.getId()) {
      case R.id.despesa_bt_salvar:
        // TODO: Criar rotina para validar e gravar o gasto
        break;
      case R.id.despesa_et_data:
        DateDialog dateDialog = new DateDialog();
        dateDialog.show(getFragmentManager(), "testes");
        break;
    }
  }

  @Override
  public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
    switch (view.getId()) {
      case R.id.despesa_sp_fonte:
        if (position == 0) {
          fonteSelecionada = null;
        } else {
          fonteSelecionada = (Fonte) adapterView.getSelectedItem();
        }
        break;
      case R.id.despesa_sp_categoria:
        if (position == 0) {
          categoriaSelecionada = null;
        } else {
          categoriaSelecionada = (Categoria) adapterView.getSelectedItem();
        }
        break;
      case R.id.despesa_sp_credor:
        if (position == 0) {
          credorSelecionado = null;
        } else {
          credorSelecionado = (Credor) adapterView.getSelectedItem();
        }
        break;
      case R.id.despesa_sp_favorecido:
        if (position == 0) {
          favorecidoSelecionado = null;
        } else {
          favorecidoSelecionado = (Favorecido) adapterView.getSelectedItem();
        }
        break;
    }
  }

  @Override
  public void onNothingSelected(AdapterView<?> adapterView) {

  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    mListener = (OnDespesaInteractionListener) context;
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }
}
