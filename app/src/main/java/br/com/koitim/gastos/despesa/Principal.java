package br.com.koitim.gastos.despesa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Date;
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

public class Principal extends AppCompatActivity implements OnDespesaInteractionListener  {

  private FonteDAO fonteDAO;
  private CategoriaDAO categoriaDAO;
  private CredorDAO credorDAO;
  private FavorecidoDAO favorecidoDAO;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.despesa_principal_layout);

    fonteDAO = new FonteDAO(this);
    categoriaDAO = new CategoriaDAO(this);
    credorDAO = new CredorDAO(this);
    favorecidoDAO = new FavorecidoDAO(this);

    FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
    Cadastro cadastro = new Cadastro();
    ft.add(R.id.despesa_principal_layout, cadastro);
    ft.commit();
  }

  @Override
  public List<Fonte> getFontes() {
    return fonteDAO.findAll();
  }

  @Override
  public List<Categoria> getCategorias() {
    return categoriaDAO.findAll();
  }

  @Override
  public List<Credor> getCredores() {
    return credorDAO.findAll();
  }

  @Override
  public List<Favorecido> getFavorecidos() {
    return favorecidoDAO.findAll();
  }

  @Override
  public Date validarData(int ano, int mes, int dia) {
    Calendar dataAtual = Calendar.getInstance();
    if (ano > dataAtual.get(Calendar.YEAR)) {
      return null;
    }
    if (ano == dataAtual.get(Calendar.YEAR) && mes > dataAtual.get(Calendar.MONTH)) {
      return null;
    }
    if (ano == dataAtual.get(Calendar.YEAR) && mes == dataAtual.get(Calendar.MONTH) && dia > dataAtual.get(Calendar.DAY_OF_MONTH)) {
      return null;
    }
    Calendar dataSelecionada = Calendar.getInstance();
    dataSelecionada.set(ano, mes, dia);
    return dataSelecionada.getTime();
  }

  @Override
  public Float validarValor(String valor) {
    return Float.parseFloat(valor);
  }
}
